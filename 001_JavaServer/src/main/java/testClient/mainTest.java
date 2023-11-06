package testClient;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import origin.protobuf.AnnouncementServiceGrpc;
import origin.protobuf.UserProto;
import origin.protobuf.UserServiceGrpc;
import origin.shared.UserEntity;


public class mainTest
{
    public static void main(String[] args)
    {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 9090) .usePlaintext() .build();
        UserServiceGrpc.UserServiceBlockingStub petOwnerStub = UserServiceGrpc.newBlockingStub(managedChannel);
        AnnouncementServiceGrpc.AnnouncementServiceBlockingStub announcementStub = AnnouncementServiceGrpc.newBlockingStub(managedChannel);


        UserProto userRequest = UserProto.newBuilder()
                .setUsername("Allan")
                .setPassword("via123")
                .setAge(40)
                .setPhone("078830013")
                .setEmail("allan@gmail.com")
                .build();
        UserProto response = petOwnerStub.createUser(userRequest);

        System.out.println(response.getEmail());
        managedChannel.shutdown();
    }
}
