package dk.via.sep3.DAOInterfaces;

import dk.via.sep3.shared.CareTakerEntity;
import dk.via.sep3.shared.PetOwnerEntity;
import dk.via.sep3.shared.PetServiceEntity;
import origin.protobuf.ServiceProto;

import java.util.Collection;

public interface PetServiceDAOInterface
{
    PetServiceEntity createService(PetServiceEntity petServiceEntity);
    void endService(int requestServiceId);
    PetServiceEntity findServiceById(int serviceId);
    Collection<PetServiceEntity> searchServices(CareTakerEntity careTaker, PetOwnerEntity petOwner, ServiceProto.Status status);
}
