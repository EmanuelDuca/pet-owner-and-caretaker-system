package dk.via.sep3.mappers;

import com.google.protobuf.Int32Value;
import com.google.protobuf.StringValue;
import dk.via.sep3.shared.CareTakerEntity;
import dk.via.sep3.shared.PetOwnerEntity;
import dk.via.sep3.shared.UserEntity;
import origin.protobuf.UserProto;

public class UserMapper {
    public static UserProto mapProto(UserEntity user)
    {
        return UserProto.newBuilder()
                .setEmail(user.getEmail())
                .setUsername(user.getUsername())
                .setPassword(user.getPassword())

//                .setType(user.getType())
                .build();
    }

    public static UserEntity mapToShared(UserProto user)
    {
        var userToReturn = new UserEntity(
                user.getEmail(),
                user.getUsername(),
                user.getPassword(),
                user.hasAge()? user.getAge().getValue() : null,
                user.hasPhone()? user.getPhone().getValue() : null,
                user.hasName()? user.getName().getValue() : null
        );

        if(user.getType().equals("PetOwner"))
            return new PetOwnerEntity(userToReturn);

        if(user.getType().equals("CareTaker"))
            return new CareTakerEntity(userToReturn);

        return null;
    }
}
