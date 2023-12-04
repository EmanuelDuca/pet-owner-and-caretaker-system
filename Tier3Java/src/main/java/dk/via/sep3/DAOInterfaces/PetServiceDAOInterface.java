package dk.via.sep3.DAOInterfaces;

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
    Collection<ServiceEntity> searchServices(UserEntity careTaker, UserEntity petOwner, ServiceStatus status);
    void giveFeedback(FeedbackEntity feedback);
    Collection<FeedbackEntity> getFeedbacks(UserEntity careTaker);

    void deleteFeedback(int serviceId, String caretakerEmail);
}
