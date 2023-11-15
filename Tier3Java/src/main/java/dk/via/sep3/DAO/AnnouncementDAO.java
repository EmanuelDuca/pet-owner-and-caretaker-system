package dk.via.sep3.DAO;

import dk.via.sep3.DAOInterfaces.AnnouncementDAOInterface;
import dk.via.sep3.repository.AnnouncementRepository;
import dk.via.sep3.repository.PetRepository;
import dk.via.sep3.repository.UserRepository;
import dk.via.sep3.shared.AnnouncementEntity;
import dk.via.sep3.shared.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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
        if ( !announcementRepository.existsById(announcementEntity.getId()))
        {
            petRepository.save(announcementEntity.getPetEntity());
            announcementRepository.save(announcementEntity);
            return announcementEntity;
        }
        return null;
    }

    @Override
    public AnnouncementEntity updateAnnouncement(AnnouncementEntity announcementEntity)
    {
        Optional<AnnouncementEntity> a = announcementRepository.findById(announcementEntity.getId());
        AnnouncementEntity announcement = a.get();
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
        if ( announcementRepository.existsById(announcementId))
        {
            return announcementRepository.getReferenceById(announcementId);
        }
        else
        {
            return null;
        }
    }

    @Override
    public Collection<AnnouncementEntity> getAllAnnouncements()
    {
        return announcementRepository.findAll();
    }

    @Override
    public Collection<AnnouncementEntity> getAnnouncements(String petOwnerEmail, String timeStart, String timeFinish, String postalCode, String petType, int petWeight, boolean petIsVaccinated)
    {
//        Collection<AnnouncementEntity> announcements = announcementRepository.findAll();
//        Collection<AnnouncementEntity> announcementResult = new ArrayList<AnnouncementEntity>();
//        for (var announcement : announcements)
//        {
//            if ()
//            {
//                announcementResult.add(announcement);
//            }
//        }
//        return announcementResult;
        return null;
    }

    @Override
    public String deleteAnnouncement(AnnouncementEntity announcementEntity)
    {
        if ( announcementRepository.existsById(announcementEntity.getId()))
        {
            announcementRepository.deleteById(announcementEntity.getId());
            return "User Deleted";
        }
        else
        {
            return "User Not Found";
        }
    }
}
