package origin.mappers;

import origin.protobuf.UserProto;
import origin.shared.CaretakerEntity;
import origin.shared.PetOwnerEntity;
import origin.shared.UserEntity;

public class UserMapper
{
    public static UserProto mapProto(UserEntity user)
    {
        var userProto = UserProto.newBuilder()
                .setUsername(user.getUsername())
                .setPassword(user.getPassword())
                .setAge(user.getAge())
                .setPhone(user.getPhone())
                .setEmail(user.getEmail());

        if (user.getClass().equals(PetOwnerEntity.class))
        {
            userProto.setType("PetOwner");
        } else if (user.getClass().equals(CaretakerEntity.class))
        {
            userProto.setType("CareTaker");
        }

        return userProto.build();
    }

    public static UserEntity mapToShared(UserProto user)
    {
        return switch (user.getType())
        {
            case "PetOwner":
                new PetOwnerEntity(
                        user.getUsername(),
                        user.getPassword(),
                        user.getAge(),
                        user.getPhone(),
                        user.getEmail());
            case "CareTaker":
                new CaretakerEntity(
                        user.getUsername(),
                        user.getPassword(),
                        user.getAge(),
                        user.getPhone(),
                        user.getEmail());
            default:
                yield new UserEntity();
        };
    }
}
