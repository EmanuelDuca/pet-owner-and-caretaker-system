package dk.via.sep3.DAOInterfaces;

import dk.via.sep3.shared.AnnouncementEntity;
import dk.via.sep3.shared.CareServiceRequestEntity;

public interface CareRequestServiceDaoInterface
{
    CareServiceRequestEntity createAnnouncement(CareServiceRequestEntity careServiceEntity);
}
