package dk.via.sep3.services;

import dk.via.sep3.DAOInterfaces.PetServiceDAOInterface;
import dk.via.sep3.model.ServiceEntity;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FinishServiceScheduler
{
    private final PetServiceDAOInterface serviceDao;

    public FinishServiceScheduler(PetServiceDAOInterface serviceDao) {
        this.serviceDao = serviceDao;
    }

    public void scheduleServiceEnd(ServiceEntity service) {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        LocalDateTime now = LocalDateTime.now();
        long initialDelay = Duration.between(now, service.getFinishDate()).toSeconds();
        System.err.println("Should be ended in " + initialDelay);
        executor.schedule(() ->
        {
            serviceDao.endService(service.getId());
            System.err.println("Scheduler was called");
        }, initialDelay, TimeUnit.SECONDS);
    }
}
