package dk.via.sep3.DAOInterfaces;

import dk.via.sep3.model.AnnouncementEntity;
import dk.via.sep3.model.FeedbackEntity;
import dk.via.sep3.model.ServiceEntity;
import dk.via.sep3.model.UserEntity;
import origin.protobuf.ServiceStatus;

import java.util.Collection;

public interface PetServiceDAOInterface
{
    ServiceEntity createService(ServiceEntity service);
    void endService(int serviceId);
    ServiceEntity findServiceById(int serviceId);
    Collection<ServiceEntity> searchServices(String careTaker, String petOwner, ServiceStatus status);
    void giveFeedback(FeedbackEntity feedback);
    Collection<FeedbackEntity> getFeedbacks(UserEntity careTaker);

    void deleteFeedback(int serviceId);

    boolean exists(AnnouncementEntity announcement, UserEntity careTaker, UserEntity recipient);
}
