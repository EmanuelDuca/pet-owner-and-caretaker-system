package dk.via.sep3.DAO;

import dk.via.sep3.DAOInterfaces.PetServiceDAOInterface;
import dk.via.sep3.repository.PetServiceRepository;
import dk.via.sep3.shared.CareTakerEntity;
import dk.via.sep3.shared.PetOwnerEntity;
import dk.via.sep3.shared.PetServiceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import origin.protobuf.ServiceProto;

import java.util.Collection;

@Repository
public class PetServiceDAO implements PetServiceDAOInterface
{
    private final PetServiceRepository repository;

    @Autowired
    public PetServiceDAO(PetServiceRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public PetServiceEntity createService(PetServiceEntity service)
    {
        service.setStatus(ServiceProto.Status.PLANNED);
        return repository.save(service);
    }

    @Override
    public void endService(int serviceId)
    {
        var serviceToUpdate = findServiceById(serviceId);
        serviceToUpdate.setStatus(ServiceProto.Status.DONE);
        repository.save(serviceToUpdate);
    }

    @Override
    public PetServiceEntity findServiceById(int serviceId)
    {
        return repository.getReferenceById(serviceId);
    }

    @Override
    public Collection<PetServiceEntity> searchServices(CareTakerEntity careTaker, PetOwnerEntity petOwner, ServiceProto.Status status)
    {
        return repository.findAll()
                .stream()
                .filter(s -> careTaker == null || careTaker.equals(s.getCareTaker()))
                .filter(s -> petOwner == null || petOwner.equals(s.getPetOwner()))
                .filter(s -> status == null || status.equals(s.getStatus()))
                .toList();

    }
}
