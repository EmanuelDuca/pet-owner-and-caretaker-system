package dk.via.sep3.testClient;


import io.grpc.*;
import origin.protobuf.*;

public class mainTest
{
    public static void main(String[] args)
    {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 9090) .usePlaintext() .build();
        UserServiceGrpc.UserServiceBlockingStub userStub = UserServiceGrpc.newBlockingStub(managedChannel);

        UserProto user = UserProto.newBuilder()
                .setEmail("allan@gmail.com")
                .setUsername("Allan")
                .setPassword("via123")
                .setAge(40)
                .setPhone("078830013")
                .setType("petOwner")
                .build();
        UserProto response = userStub.createUser(user);
        System.out.println(response.getEmail());

        managedChannel.shutdown();
    }
}
