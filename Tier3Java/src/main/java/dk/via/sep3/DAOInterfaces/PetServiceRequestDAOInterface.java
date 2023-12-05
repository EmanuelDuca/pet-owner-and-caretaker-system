package dk.via.sep3.DAOInterfaces;

import dk.via.sep3.model.RequestEntity;

import java.util.Collection;

public interface PetServiceRequestDAOInterface
{
    RequestEntity createServiceRequest(RequestEntity serviceEntity);
    Collection<RequestEntity> searchServiceRequests(int announcementId);
    boolean deleteServiceRequests(int announcementId);
    void confirmServiceRequest(int serviceId);
    void denyServiceRequest(int serviceId);
    RequestEntity getServiceRequestById(int serviceRequestId);
}
