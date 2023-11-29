package dk.via.sep3.DAOInterfaces;

import dk.via.sep3.shared.CareTakerEntity;
import dk.via.sep3.shared.PetOwnerEntity;
import dk.via.sep3.shared.PetServiceEntity;
import origin.protobuf.ServiceProto;
import origin.protobuf.ServiceStatus;

import java.util.Collection;

public interface PetServiceDAOInterface
{
    PetServiceEntity createService(PetServiceEntity service);
    void endService(int serviceId);
    PetServiceEntity findServiceById(int serviceId);
    Collection<PetServiceEntity> searchServices(CareTakerEntity careTaker, PetOwnerEntity petOwner, ServiceStatus status);
}
