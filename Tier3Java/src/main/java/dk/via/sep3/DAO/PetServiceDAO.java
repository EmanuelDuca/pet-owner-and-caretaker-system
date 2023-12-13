package dk.via.sep3.DAO;

import dk.via.sep3.DAOInterfaces.PetServiceDAOInterface;
import dk.via.sep3.model.AnnouncementEntity;
import dk.via.sep3.repository.FeedbackRepository;
import dk.via.sep3.repository.ServiceRepository;
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
    private final ServiceRepository repository;
    private final FeedbackRepository feedbackRepository;

    @Autowired
    public PetServiceDAO(ServiceRepository repository, FeedbackRepository feedbackRepository)
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

    public Collection<ServiceEntity> searchServices(String careTaker, String petOwner, ServiceStatus status)
    {
        return repository.findAll()
                .stream()
                .filter(s -> careTaker == null || careTaker.equals(s.getCareTaker().getEmail()))
                .filter(s -> petOwner == null || petOwner.equals(s.getPetOwner().getEmail()))
                .filter(s -> status == ServiceStatus.UNRECOGNIZED || status.equals(s.getStatus()))
                .toList();

    }

    @Override
    @Transactional
    public void giveFeedback(FeedbackEntity feedback)
    {
        if(feedbackRepository.findAll().stream().anyMatch(f -> f.getService().getId() == feedback.getService().getId()))
            throw new RuntimeException("Feedback for this service already exists");

        var service = repository.getReferenceById(feedback.getService().getId());
        service.setFeedback(feedback);
        feedbackRepository.save(feedback);
        repository.save(service);
    }

    @Override
    @Transactional
    public Collection<FeedbackEntity> getFeedbacks(UserEntity careTaker)
    {
        return feedbackRepository.findAll().stream()
                .filter(f -> f.getService().getCareTaker().getEmail().equals(careTaker.getEmail()))
                .toList();
    }

    @Override
    @Transactional
    public void deleteFeedback(int feedbackId)
    {
        feedbackRepository.deleteById(new FeedbackEntity.FeedbackId(feedbackId));
    }

    @Override
    @Transactional
    public boolean exists(AnnouncementEntity announcement, UserEntity careTaker, UserEntity petowner)
    {
        return repository.findAll().stream().anyMatch(service ->
                service.getCareTaker().getEmail().equals(careTaker.getEmail()) &&
                        service.getPetOwner().getEmail().equals(petowner.getEmail()) &&
                        announcement.getId() == service.getAnnouncement().getId()

        );
    }


}
