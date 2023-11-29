package dk.via.sep3.DAO;

import dk.via.sep3.DAOInterfaces.PetServiceRequestDAOInterface;
import dk.via.sep3.repository.AnnouncementRepository;
import dk.via.sep3.repository.PetServiceRequestRepository;
import dk.via.sep3.repository.UserRepository;
import dk.via.sep3.shared.PetServiceRequestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import origin.protobuf.SearchServiceProto;

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
    public PetServiceRequestEntity createServiceRequest(PetServiceRequestEntity careServiceEntity)
    {
        if(!userRepository.existsById(careServiceEntity.getInitiator().getEmail())
        || !userRepository.existsById(careServiceEntity.getRecipient().getEmail())
        || !announcementRepository.existsById(careServiceEntity.getAnnouncement().getId()))
            return null;

        return repository.save(careServiceEntity);
    }

    @Override
    public Collection<PetServiceRequestEntity> searchRequestServices(SearchServiceProto searchProto)
    {
        return null;
    }

    @Override
    public boolean deleteServiceRequest(int id)
    {
        return false;
    }
}
