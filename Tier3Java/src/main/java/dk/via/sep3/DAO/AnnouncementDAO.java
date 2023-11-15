package dk.via.sep3.DAO;

import com.google.common.base.Strings;
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
        return announcementRepository.findAll()
                .stream()
                .filter(a -> Strings.isNullOrEmpty(searchDto.getPetOwnerEmail()) || searchDto.getPetOwnerEmail().equals(a.getPetOwner().getEmail()))
                .filter(a -> Strings.isNullOrEmpty(searchDto.getPetType()) || searchDto.getPetType().equals(a.getPetOwner().getType()))
                .filter(a -> Strings.isNullOrEmpty(searchDto.getTimeFinish()) || searchDto.getTimeFinish().equals(a.getFinishDate()))
                .filter(a -> Strings.isNullOrEmpty(searchDto.getTimeStart()) || searchDto.getTimeStart().equals(a.getStartDate()))
                .filter(a -> Strings.isNullOrEmpty(searchDto.getPostalCode()) || searchDto.getPostalCode().equals(a.getPostalCode()))
                .toList();
//                .filter(a -> searchDto.getPetWeight() <= 0 || searchDto.getPetWeight() == a.getPet().getWeight())
//                .filter(a -> searchDto.getPetIsVaccinated() <= 0 || searchDto.getPetWeight() == a.getPet().getWeight())
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
