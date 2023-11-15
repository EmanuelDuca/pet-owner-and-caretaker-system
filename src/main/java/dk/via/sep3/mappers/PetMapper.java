package dk.via.sep3.mappers;


import dk.via.sep3.DAO.UserDAO;
import dk.via.sep3.DAOInterfaces.UserDAOInterface;
import dk.via.sep3.shared.PetEntity;
import dk.via.sep3.shared.PetOwnerEntity;
import origin.protobuf.*;

public class PetMapper
{
    public static PetProto mapToProto(PetEntity petEntity)
    {
        return PetProto.newBuilder()
                .setPetName(petEntity.getPetName())
                .setPetType(petEntity.getPetType())
                .setWeight(petEntity.getWeight())
                .setIsVaccinated(petEntity.isVaccinated())
                .setDescription(petEntity.getDietDescription())
                .setOwnerEmail(petEntity.getPetOwner().getEmail())
                .build();
    }
}
