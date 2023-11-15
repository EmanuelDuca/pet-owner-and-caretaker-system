package dk.via.sep3.testClient;


import io.grpc.*;
import origin.protobuf.*;

import java.lang.String;

public class mainTest
{

    public static void main(String[] args)
    {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 9091) .usePlaintext() .build();
        UserServiceGrpc.UserServiceBlockingStub userStub = UserServiceGrpc.newBlockingStub(managedChannel);
        AnnouncementServiceGrpc.AnnouncementServiceBlockingStub announcementStub = AnnouncementServiceGrpc.newBlockingStub(managedChannel);


        // Test create user
        UserProto user = UserProto.newBuilder()
                .setEmail("allan5@gmail.com")
                .setUsername("Allan")
                .setPassword("via123")
                .setAge(40)
                .setPhone("078830013")
                .setType("CareTaker")
                .build();
        try {
            UserProto response = userStub.createUser(user);
            System.out.println(response.getEmail());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }


        System.out.println(announcementStub.findAnnouncements(null));


        //Test find user by email
        UserProto userGet = userStub.findUser(FindUserProto.newBuilder().setEmail("allan@gmail.com").build());
        System.out.println(userGet.getPassword());

        //Test login
        UserProto userLogIn = userStub.logIn(LoginUserProto.newBuilder().setEmail("allan@gmail.com").setPassword("via123").build());
        System.out.println(userLogIn.getPassword());

        //Test search by type
        UsersProto users1 = userStub.searchUser(SearchUsersProto.newBuilder().setType("PetOwner").build());
        System.out.println(users1.getUsersCount());
        UsersProto users2 = userStub.searchUser(SearchUsersProto.newBuilder().setType("CareTaker").build());
        System.out.println(users2.getUsersCount());



        //Create announcement
        AnnouncementProto announcementProto = AnnouncementProto.newBuilder()
                .setPetOwnerEmail("allan@gmail.com")
                .setTimeStart("01.01.2024")
                .setTimeFinish("01.01.2025")
                .setDescription("uraaaaaaaaaaaaaaaaaaaaa")
                .setPostalCode("8700")
                .setPet(PetProto.newBuilder()
                        .setOwnerEmail("allan@gmail.com")
                        .setPetName("HUI_VAM")
                        .setPetType("cat")
                        .setIsVaccinated(false)
                        .setDescription("miau miau maiu")
                        .setWeight(25)
                        .build())
                .build();
        AnnouncementProto announcementProtoResponse = announcementStub.createAnnouncement(announcementProto);
            System.out.println(announcementProtoResponse.getDescription());


        UserProto user1 = userStub.findUser(FindUserProto.newBuilder().setEmail("allan@gmail.com").build());
        System.out.println(user1.getPhone());



        managedChannel.shutdown();
    }
}
