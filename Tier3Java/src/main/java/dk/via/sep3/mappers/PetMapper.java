package dk.via.sep3.mappers;


import dk.via.sep3.model.PetEntity;
import origin.protobuf.*;

public class PetMapper
{
    public static PetProto mapToProto(PetEntity petEntity)
    {
        return PetProto.newBuilder()
                .setId(petEntity.getId())
                .setPetName(petEntity.getPetName())
                .setPetType(petEntity.getPetType())
                .setWeight(petEntity.getWeight())
                .setIsVaccinated(petEntity.isVaccinated())
                .setDescription(petEntity.getDescription())
                .setOwnerEmail(petEntity.getPetOwner().getEmail())
                .build();
    }
}
