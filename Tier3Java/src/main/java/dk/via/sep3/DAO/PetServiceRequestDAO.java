package dk.via.sep3.DAO;

import dk.via.sep3.DAOInterfaces.PetServiceRequestDAOInterface;
import dk.via.sep3.repository.AnnouncementRepository;
import dk.via.sep3.repository.RequestRepository;
import dk.via.sep3.repository.UserRepository;
import dk.via.sep3.model.RequestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;
import origin.protobuf.ServiceRequestProto;

import javax.transaction.Transactional;
import java.util.Collection;

@Repository
public class PetServiceRequestDAO implements PetServiceRequestDAOInterface
{
    private final RequestRepository repository;
    private final AnnouncementRepository announcementRepository;
    private final UserRepository userRepository;

    @Autowired
    public PetServiceRequestDAO(RequestRepository repository, AnnouncementRepository announcementRepository, UserRepository userRepository)
    {
        this.repository = repository;
        this.announcementRepository = announcementRepository;
        this.userRepository = userRepository;
    }
    @Override
    @Transactional
    public RequestEntity createServiceRequest(RequestEntity careServiceEntity)
    {
        if(!userRepository.existsById(careServiceEntity.getInitiator().getEmail())
        || !userRepository.existsById(careServiceEntity.getRecipient().getEmail())
        || !announcementRepository.existsById(careServiceEntity.getAnnouncement().getId()))
            return null;

        if(repository.findAll().stream().anyMatch(serviceRequest -> serviceRequest.getAnnouncement().getId() == careServiceEntity.getAnnouncement().getId() &&
                serviceRequest.getInitiator().getEmail().equals(careServiceEntity.getInitiator().getEmail()) &&
                        serviceRequest.getRecipient().getEmail().equals(careServiceEntity.getRecipient().getEmail())))
        {
            return null;
        }

        return repository.save(careServiceEntity);
    }

    @Override
    @Transactional
    public Collection<RequestEntity> searchServiceRequests(int announcementId)
    {
        return repository.findAll()
                .stream()
                .filter(s -> s.getAnnouncement().getId() == announcementId).toList();
    }

    @Override
    @Transactional
    public boolean deleteServiceRequests(int announcementId)
    {
        var servicesToDelete = searchServiceRequests(announcementId);
        repository.deleteAll(servicesToDelete);
        return true;
    }

    @Override
    @Transactional
    public boolean confirmServiceRequest(int serviceId)
    {
        if(!repository.existsById(serviceId))
            return false;

        var serviceToUpdate = repository.getReferenceById(serviceId);
        serviceToUpdate.setStatus(ServiceRequestProto.Status.ACCEPTED);
        repository.save(serviceToUpdate);
        return false;
    }

    @Override
    @Transactional
    public boolean denyServiceRequest(int serviceId)
    {
        if(!repository.existsById(serviceId))
            return false;

        var serviceToUpdate = repository.getReferenceById(serviceId);
        serviceToUpdate.setStatus(ServiceRequestProto.Status.DENIED);
        repository.save(serviceToUpdate);
        return true;
    }

    @Override
    @Transactional
    public RequestEntity getServiceRequestById(int serviceRequestId)
    {
        return repository.getReferenceById(serviceRequestId);
    }
}
