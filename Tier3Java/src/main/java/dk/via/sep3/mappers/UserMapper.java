package dk.via.sep3.mappers;

import dk.via.sep3.shared.UserEntity;
import origin.protobuf.UserProto;

public class UserMapper {
    public static UserProto mapProto(UserEntity user)
    {
        return UserProto.newBuilder()
                .setEmail(user.getEmail())
                .setUsername(user.getUsername())
                .setPassword(user.getPassword())
                .setAge(user.getAge())
                .setPhone(user.getPhone())
                .setType(user.getType())
                .build();
    }

    public static UserEntity mapToShared(UserProto user)
    {
        return new UserEntity(
                user.getUsername(),
                user.getPassword(),
                user.getPhone(),
                user.getAge(),
                user.getEmail(),
                user.getType()
        );
    }
}
