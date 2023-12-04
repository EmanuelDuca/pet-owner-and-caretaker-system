package dk.via.sep3.DAOInterfaces;

import dk.via.sep3.shared.FeedbackEntity;
import dk.via.sep3.shared.PetServiceEntity;
import dk.via.sep3.shared.UserEntity;
import origin.protobuf.ServiceStatus;

import java.util.Collection;

public interface PetServiceDAOInterface
{
    PetServiceEntity createService(PetServiceEntity service);
    void endService(int serviceId);
    PetServiceEntity findServiceById(int serviceId);
    Collection<PetServiceEntity> searchServices(UserEntity careTaker, UserEntity petOwner, ServiceStatus status);
    void giveFeedback(FeedbackEntity feedback);
    Collection<FeedbackEntity> getFeedbacks(UserEntity careTaker);

    void deleteFeedback(int serviceId, String caretakerEmail);
}
