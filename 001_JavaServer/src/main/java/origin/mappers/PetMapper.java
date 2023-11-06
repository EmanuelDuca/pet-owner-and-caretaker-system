package origin.mappers;

import origin.protobuf.PetProto;
import origin.shared.PetEntity;

public class PetMapper {
    public static PetProto mapToProto(PetEntity petEntity)
    {
        return PetProto.newBuilder()
                .setPetName(petEntity.getPetName())
                .setPetType(petEntity.getPetType())
                .setWeight(petEntity.getWeight())
                .setDescription(petEntity.getDescription())
                .build();
    }

    public static PetEntity mapToShared(PetProto pet)
    {
        return new PetEntity(
                pet.getPetName(),
                pet.getPetType(),
                pet.getWeight(),
                pet.getDescription()
        );
    }
}
