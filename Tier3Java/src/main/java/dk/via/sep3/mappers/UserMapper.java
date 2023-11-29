package dk.via.sep3.mappers;

import com.google.protobuf.Int32Value;
import com.google.protobuf.StringValue;
import dk.via.sep3.shared.UserEntity;
import origin.protobuf.UserProto;

public class UserMapper {
    public static UserProto mapProto(UserEntity user)
    {
        return UserProto.newBuilder()
                .setEmail(user.getEmail())
                .setUsername(user.getUsername())
                .setPassword(user.getPassword())
                .setAge(Int32Value.of(user.getAge()))
                .setPhone(StringValue.of(user.getPhone()))
//                .setType(user.getType())
                .build();
    }

    public static UserEntity mapToShared(UserProto user)
    {
        return new UserEntity(
                user.getEmail(),
                user.getUsername(),
                user.getPassword(),
                user.hasAge()? user.getAge().getValue() : null,
                user.hasPhone()? user.getPhone().getValue() : null,
//                user.getType(),
                user.hasName()? user.getName().getValue() : null
        );
    }
}
