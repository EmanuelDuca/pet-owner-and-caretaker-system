package dk.via.sep3.DAO;

import dk.via.sep3.DAOInterfaces.AnnouncementDAOInterface;
import dk.via.sep3.repository.AnnouncementRepository;
import dk.via.sep3.repository.PetRepository;
import dk.via.sep3.shared.AnnouncementEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import origin.protobuf.SearchAnnouncementProto;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Repository
public class AnnouncementDAO implements AnnouncementDAOInterface
{
    private final AnnouncementRepository announcementRepository;
    private final PetRepository petRepository;


    @Autowired
    public AnnouncementDAO(AnnouncementRepository announcementRepository, PetRepository petRepository) {
        this.announcementRepository = announcementRepository;
        this.petRepository = petRepository;
    }

    @Override
    public AnnouncementEntity createAnnouncement(AnnouncementEntity announcementEntity)
    {
        if (announcementRepository.existsById(announcementEntity.getId()))
            return null;


        petRepository.save(announcementEntity.getPetEntity());
        announcementRepository.save(announcementEntity);
        return announcementEntity;
    }

    @Override
    @Transactional
    public AnnouncementEntity updateAnnouncement(AnnouncementEntity announcementEntity)
    {
        petRepository.save(announcementEntity.getPet());
        return announcementRepository.save(announcementEntity);
    }

    @Override
    public AnnouncementEntity getAnnouncement(int announcementId)
    {
        if (!announcementRepository.existsById(announcementId))
            return null;
        return announcementRepository.getReferenceById(announcementId);
    }

    @Override
    public Collection<AnnouncementEntity> getAllAnnouncements()
    {
        return announcementRepository.findAll();
    }

    @Override
    public Collection<AnnouncementEntity> getAnnouncements(SearchAnnouncementProto searchDto)
    {
        return announcementRepository.findAll();
//        return announcementRepository.findAll()
//                .stream()
//                .filter(a -> !searchDto.getPetOwnerUsername().|| searchDto.getPetOwnerUsername().getValue().equals(a.getPetOwner().getEmail()))
//                .filter(a -> !searchDto.getPetType().get || searchDto.getPetType().getValue().equals(a.getPetOwner().getType()))
//                .filter(a -> !searchDto.getTimeFinish().isInitialized() || searchDto.getTimeFinish().getValue().equals(a.getFinishDate()))
//                .filter(a -> !searchDto.getTimeStart().isInitialized() || searchDto.getTimeStart().getValue().equals(a.getStartDate()))
//                .filter(a -> !searchDto.getPostalCode().isInitialized() || searchDto.getPostalCode().getValue().equals(a.getPostalCode()))
//                .filter(a -> !searchDto.getPetWeight().getDefaultInstanceForType().|| searchDto.getPetWeight().getValue() == a.getPet().getWeight())
//                .filter(a -> !searchDto.getPetIsVaccinated().isInitialized() || searchDto.getPetIsVaccinated().getValue() == a.getPet().isVaccinated())
//                .toList();
    }

    @Override
    public boolean deleteAnnouncement(AnnouncementEntity announcementEntity)
    {
        if (announcementRepository.existsById(announcementEntity.getId()))
        {
            announcementRepository.deleteById(announcementEntity.getId());
            return true;
        }

        return false;
    }
}
