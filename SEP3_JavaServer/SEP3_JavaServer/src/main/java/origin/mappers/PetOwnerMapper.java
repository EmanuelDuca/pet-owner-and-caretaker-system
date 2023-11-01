package origin.mappers;

import origin.protobufClasses.PetOwner;
import origin.shared.PetOwnerEntity;

public class PetOwnerMapper {
    public static PetOwner mapProto(PetOwnerEntity user)
    {
        return PetOwner.newBuilder()
                .setUsername(user.getUsername())
                .setPassword(user.getPassword())
                .setAge(user.getAge())
                .setPhone(user.getPhone())
                .setEmail(user.getEmail())
                .build();
    }

    public static PetOwnerEntity mapToShared(PetOwner user)
    {
        return new PetOwnerEntity(
                user.getUsername(),
                user.getPassword(),
                user.getAge(),
                user.getPhone(),
                user.getEmail()
        );
    }
}
