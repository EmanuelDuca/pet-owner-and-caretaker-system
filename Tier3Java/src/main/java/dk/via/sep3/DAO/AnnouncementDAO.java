package dk.via.sep3.DAO;

import dk.via.sep3.DAOInterfaces.AnnouncementDAOInterface;
import dk.via.sep3.repository.AnnouncementRepository;
import dk.via.sep3.repository.PetRepository;
import dk.via.sep3.shared.AnnouncementEntity;
import dk.via.sep3.utils.TimestampConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import origin.protobuf.SearchAnnouncementProto;

import javax.transaction.Transactional;
import java.util.Collection;

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
    @Transactional
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
        return announcementRepository.findAll()
                .stream()
                .filter(a -> !searchDto.hasPetOwnerUsername() || searchDto.getPetOwnerUsername().getValue().equals(a.getPetOwner().getEmail()))
                .filter(a -> !searchDto.hasPetType() || searchDto.getPetType().getValue().equals(a.getPet().getPetType()))

                .filter(a -> !searchDto.hasTimeFinish() && !searchDto.hasTimeStart() ||
                            TimestampConverter.toLocalDateTime(searchDto.getTimeFinish()).isBefore(a.getFinishDate()) &&
                                    TimestampConverter.toLocalDateTime(searchDto.getTimeStart()).isAfter(a.getStartDate()))

                .filter(a -> !searchDto.hasPostalCode() || searchDto.getPostalCode().getValue().equals(a.getPostalCode()))
                .filter(a -> !searchDto.hasPetWeight() || searchDto.getPetWeight().getValue() == a.getPet().getWeight())
                .filter(a -> !searchDto.hasPetIsVaccinated() || searchDto.getPetIsVaccinated().getValue() == a.getPet().isVaccinated())
                .toList();
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
