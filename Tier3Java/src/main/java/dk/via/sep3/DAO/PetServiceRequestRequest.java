package dk.via.sep3.DAO;

import dk.via.sep3.DAOInterfaces.PetServiceRequestInterface;
import dk.via.sep3.repository.AnnouncementRepository;
import dk.via.sep3.repository.PetServiceRequestRepository;
import dk.via.sep3.repository.UserRepository;
import dk.via.sep3.shared.CareServiceRequestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PetServiceRequestRequest implements PetServiceRequestInterface
{
    private final PetServiceRequestRepository repository;
    private final AnnouncementRepository announcementRepository;
    private final UserRepository userRepository;

    @Autowired
    public PetServiceRequestRequest(PetServiceRequestRepository repository, AnnouncementRepository announcementRepository, UserRepository userRepository)
    {
        this.repository = repository;
        this.announcementRepository = announcementRepository;
        this.userRepository = userRepository;
    }
    @Override
    public CareServiceRequestEntity createServiceRequestOffer(CareServiceRequestEntity careServiceEntity)
    {
        if(!userRepository.existsById(careServiceEntity.getInitiator().getEmail())
        || !userRepository.existsById(careServiceEntity.getRecipient().getEmail())
        || !announcementRepository.existsById(careServiceEntity.getAnnouncement().getId()))
            return null;

        return repository.save(careServiceEntity);
    }
}
