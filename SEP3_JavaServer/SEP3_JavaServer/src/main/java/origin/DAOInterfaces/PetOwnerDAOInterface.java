package origin.DAOInterfaces;


import origin.shared.PetOwnerEntity;

import java.util.Collection;

public interface PetOwnerDAOInterface {
    PetOwnerEntity registerUser(PetOwnerEntity petOwnerEntity);

    PetOwnerEntity loginPetOwner(PetOwnerEntity petOwnerEntity);

    PetOwnerEntity findPetOwner(String username);

    void updatePetOwnerInformation(PetOwnerEntity petOwnerEntity);

    Collection<PetOwnerEntity> getAllPetOwners();

    Collection<PetOwnerEntity> getPetOwners(String searchField);
}
