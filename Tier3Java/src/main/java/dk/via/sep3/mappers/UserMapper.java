package dk.via.sep3.mappers;

import com.google.protobuf.Int32Value;
import com.google.protobuf.StringValue;
import dk.via.sep3.model.UserEntity;
import origin.protobuf.UserProto;

public class UserMapper {
    public static UserProto mapToProto(UserEntity user)
    {
        var proto = UserProto.newBuilder()
                .setEmail(user.getEmail())
                .setUsername(user.getUsername())
                .setPassword(user.getPassword())
                .setType(user.getUserType());

        if(user.getName() != null)
            proto.setName(StringValue.of(user.getName()));

        if(user.getAge() != null)
            proto.setAge(Int32Value.of(user.getAge()));

        if(user.getPhone() != null)
            proto.setPhone(StringValue.of(user.getPhone()));

        return proto.build();
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
