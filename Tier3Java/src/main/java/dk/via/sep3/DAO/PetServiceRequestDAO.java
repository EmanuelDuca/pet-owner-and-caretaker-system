package dk.via.sep3.DAO;

import dk.via.sep3.DAOInterfaces.PetServiceRequestDAOInterface;
import dk.via.sep3.repository.AnnouncementRepository;
import dk.via.sep3.repository.PetServiceRequestRepository;
import dk.via.sep3.repository.UserRepository;
import dk.via.sep3.shared.PetServiceRequestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import origin.protobuf.SearchServiceProto;
import origin.protobuf.ServiceRequestProto;

import javax.transaction.Transactional;
import java.util.Collection;

@Repository
public class PetServiceRequestDAO implements PetServiceRequestDAOInterface
{
    private final PetServiceRequestRepository repository;
    private final AnnouncementRepository announcementRepository;
    private final UserRepository userRepository;

    @Autowired
    public PetServiceRequestDAO(PetServiceRequestRepository repository, AnnouncementRepository announcementRepository, UserRepository userRepository)
    {
        this.repository = repository;
        this.announcementRepository = announcementRepository;
        this.userRepository = userRepository;
    }
    @Override
    @Transactional
    public PetServiceRequestEntity createServiceRequest(PetServiceRequestEntity careServiceEntity)
    {
        if(!userRepository.existsById(careServiceEntity.getInitiator().getEmail())
        || !userRepository.existsById(careServiceEntity.getRecipient().getEmail())
        || !announcementRepository.existsById(careServiceEntity.getAnnouncement().getId()))
            return null;

        return repository.save(careServiceEntity);
    }

    @Override
    @Transactional
    public Collection<PetServiceRequestEntity> searchServiceRequests(int announcementId)
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
    public void confirmServiceRequest(int serviceId)
    {
        var serviceToUpdate = repository.getReferenceById(serviceId);
        serviceToUpdate.setStatus(ServiceRequestProto.Status.ACCEPTED);
        repository.save(serviceToUpdate);
    }

    @Override
    @Transactional
    public void denyServiceRequest(int serviceId)
    {
        var serviceToUpdate = repository.getReferenceById(serviceId);
        serviceToUpdate.setStatus(ServiceRequestProto.Status.DENIED);
        repository.save(serviceToUpdate);
    }

    @Override
    @Transactional
    public PetServiceRequestEntity getServiceRequestById(int serviceRequestId)
    {
        return repository.getReferenceById(serviceRequestId);
    }
}
