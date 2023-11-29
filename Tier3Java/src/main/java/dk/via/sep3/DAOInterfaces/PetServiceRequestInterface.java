package dk.via.sep3.DAOInterfaces;

import dk.via.sep3.shared.CareServiceRequestEntity;

public interface PetServiceRequestInterface
{
    CareServiceRequestEntity createServiceRequestOffer(CareServiceRequestEntity careServiceEntity);
}
