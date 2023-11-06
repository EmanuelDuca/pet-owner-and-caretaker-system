package origin.DAO;

import origin.DAOInterfaces.AnnouncementDAOInterface;
import origin.File.FileServer;
import origin.shared.AnnouncementEntity;

import java.util.Collection;

public class AnnouncementDAO implements AnnouncementDAOInterface {

    private FileServer database;

    public AnnouncementDAO() {
        database = FileServer.getInstance();
    }

    @Override
    public AnnouncementEntity createAnnouncement(AnnouncementEntity announcementEntity)
    {
        database.AppendToFile(announcementEntity);
        return announcementEntity;

    }

    @Override
    public void updateAnnouncement(AnnouncementEntity announcementEntity) {

    }

    @Override
    public AnnouncementEntity getAnnouncement(String petOwnerEmail) {
        return null;
    }

    @Override
    public Collection<AnnouncementEntity> getAllAnnouncements() {
        return null;
    }

    @Override
    public Collection<AnnouncementEntity> getAnnouncements(String searchField) {
        return null;
    }

    @Override
    public void deleteAnnouncement(AnnouncementEntity announcementEntity) {

    }
}
