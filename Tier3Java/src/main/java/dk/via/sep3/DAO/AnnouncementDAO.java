package dk.via.sep3.DAO;

import dk.via.sep3.DAOInterfaces.AnnouncementDAOInterface;
import dk.via.sep3.repository.AnnouncementRepository;
import dk.via.sep3.repository.PetRepository;
import dk.via.sep3.shared.AnnouncementEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import origin.protobuf.SearchAnnouncementProto;

import java.util.Collection;
import java.util.Optional;

@Repository
public class AnnouncementDAO implements AnnouncementDAOInterface
{
    @Autowired
    private AnnouncementRepository announcementRepository;
    @Autowired
    private PetRepository petRepository;


    public AnnouncementDAO() {
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
    public AnnouncementEntity updateAnnouncement(AnnouncementEntity announcementEntity)
    {
        Optional<AnnouncementEntity> a = announcementRepository.findById(announcementEntity.getId());
        AnnouncementEntity announcement = a.orElseThrow(() ->
                new RuntimeException("Announcement with id " + announcementEntity.getId() + " doesn't exist."));

        announcement.setPet(announcementEntity.getPet());
        announcement.setDescription((announcementEntity.getDescription()));
        announcement.setStartDate(announcementEntity.getStartDate());
        announcement.setFinishDate(announcementEntity.getFinishDate());
        announcement.setPostalCode(announcementEntity.getPostalCode());
        announcementRepository.save(announcement);
        return announcement;
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