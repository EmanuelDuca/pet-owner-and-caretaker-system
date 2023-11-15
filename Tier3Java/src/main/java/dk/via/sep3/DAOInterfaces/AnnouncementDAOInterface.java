package dk.via.sep3.DAOInterfaces;

import dk.via.sep3.shared.AnnouncementEntity;
import origin.protobuf.SearchAnnouncementProto;

import java.util.Collection;

public interface AnnouncementDAOInterface {
    AnnouncementEntity createAnnouncement(AnnouncementEntity announcementEntity);

    AnnouncementEntity updateAnnouncement(AnnouncementEntity announcementEntity);

    AnnouncementEntity getAnnouncement(int announcementId);

    Collection<AnnouncementEntity> getAllAnnouncements();

    Collection<AnnouncementEntity> getAnnouncements(SearchAnnouncementProto announcementProto);

    boolean deleteAnnouncement(AnnouncementEntity announcementEntity);
}
