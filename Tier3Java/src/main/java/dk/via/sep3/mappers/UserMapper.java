package dk.via.sep3.mappers;

import dk.via.sep3.shared.UserEntity;
import origin.protobuf.UserProto;

public class UserMapper {
    public static UserProto mapToProto(UserEntity user)
    {
        return UserProto.newBuilder()
                .setEmail(user.getEmail())
                .setUsername(user.getUsername())
                .setPassword(user.getPassword())
                .setType(user.getUserType())
                .build();
    }

    public static UserEntity mapToEntity(UserProto user)
    {
        return new UserEntity(
                user.getEmail(),
                user.getUsername(),
                user.getPassword(),
                user.getType(),
                user.hasAge()? user.getAge().getValue() : null,
                user.hasPhone()? user.getPhone().getValue() : null,
                user.hasName()? user.getName().getValue() : null
        );
    }
}
