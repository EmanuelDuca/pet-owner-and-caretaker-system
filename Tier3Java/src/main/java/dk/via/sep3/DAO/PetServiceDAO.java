package dk.via.sep3.DAO;

import dk.via.sep3.DAOInterfaces.PetServiceDAOInterface;
import dk.via.sep3.repository.FeedbackRepository;
import dk.via.sep3.repository.PetServiceRepository;
import dk.via.sep3.model.FeedbackEntity;
import dk.via.sep3.model.ServiceEntity;
import dk.via.sep3.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;
import origin.protobuf.ServiceStatus;

import javax.transaction.Transactional;
import java.util.Collection;

@Repository
public class PetServiceDAO implements PetServiceDAOInterface
{
    private final PetServiceRepository repository;
    private final FeedbackRepository feedbackRepository;

    @Autowired
    public PetServiceDAO(PetServiceRepository repository, FeedbackRepository feedbackRepository)
    {
        this.repository = repository;
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    @Transactional
    public ServiceEntity createService(ServiceEntity service)
    {
        if(repository.exists(Example.of(service)))
            return null;

        return repository.save(service);
    }

    @Override
    @Transactional
    public void endService(int serviceId)
    {
        var serviceToUpdate = findServiceById(serviceId);
        serviceToUpdate.setStatus(ServiceStatus.DONE);
        repository.save(serviceToUpdate);
    }

    @Override
    @Transactional
    public ServiceEntity findServiceById(int serviceId)
    {
        return repository.getReferenceById(serviceId);
    }

    @Override
    @Transactional

    public Collection<ServiceEntity> searchServices(UserEntity careTaker, UserEntity petOwner, ServiceStatus status)
    {
        return repository.findAll()
                .stream()
                .filter(s -> careTaker == null || careTaker.equals(s.getCareTaker()))
                .filter(s -> petOwner == null || petOwner.equals(s.getPetOwner()))
                .filter(s -> status == null || status.equals(s.getStatus()))
                .toList();

    }

    @Override
    @Transactional
    public void giveFeedback(FeedbackEntity feedback)
    {
        var service = repository.getReferenceById(feedback.getService().getId());
        service.setFeedback(feedback);
        repository.save(service);
    }

    @Override
    @Transactional
    public Collection<FeedbackEntity> getFeedbacks(UserEntity careTaker)
    {
        return feedbackRepository.findAll().stream()
                .filter(f -> f.getCaretaker().equals(careTaker))
                .toList();
    }

    @Override
    @Transactional
    public void deleteFeedback(int feedbackId, String caretakerEmail)
    {
        feedbackRepository.deleteById(new FeedbackEntity.FeedbackId(feedbackId, caretakerEmail));
    }


}
