package dk.via.sep3.DAOInterfaces;

import dk.via.sep3.shared.PetServiceRequestEntity;

import java.util.Collection;

public interface PetServiceRequestDAOInterface
{
    PetServiceRequestEntity createServiceRequest(PetServiceRequestEntity serviceEntity);
    Collection<PetServiceRequestEntity> searchServiceRequests(int announcementId);
    boolean deleteServiceRequests(int announcementId);
    void confirmServiceRequest(int serviceId);
    void denyServiceRequest(int serviceId);
    PetServiceRequestEntity getServiceRequestById(int serviceRequestId);
}
