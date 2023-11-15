package dk.via.sep3.DAOInterfaces;

import dk.via.sep3.shared.AnnouncementEntity;

import java.util.Collection;

public interface AnnouncementDAOInterface {
    AnnouncementEntity createAnnouncement(AnnouncementEntity announcementEntity);

    AnnouncementEntity updateAnnouncement(AnnouncementEntity announcementEntity);

    AnnouncementEntity getAnnouncement(int announcementId);

    Collection<AnnouncementEntity> getAllAnnouncements();

    Collection<AnnouncementEntity> getAnnouncements(
                                          String petOwnerEmail,
                                          String timeStart,
                                          String timeFinish,
                                          String postalCode,
                                          String petType,
                                          int petWeight,
                                          boolean petIsVaccinated);

    String deleteAnnouncement(AnnouncementEntity announcementEntity);
}
