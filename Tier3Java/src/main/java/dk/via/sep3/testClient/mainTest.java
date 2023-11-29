package dk.via.sep3.testClient;


import com.google.protobuf.StringValue;
import com.google.protobuf.Timestamp;
import dk.via.sep3.mappers.AnnouncementMapper;
import dk.via.sep3.utils.TimestampConverter;
import io.grpc.*;
import origin.protobuf.*;

import java.lang.String;
import java.time.LocalDateTime;

public class mainTest
{

    public static void main(String[] args)
    {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 9090) .usePlaintext() .build();
        UserServiceGrpc.UserServiceBlockingStub userStub = UserServiceGrpc.newBlockingStub(managedChannel);
        AnnouncementServiceGrpc.AnnouncementServiceBlockingStub announcementStub = AnnouncementServiceGrpc.newBlockingStub(managedChannel);
        ServiceServiceGrpc.ServiceServiceBlockingStub serviceBlockingStub = ServiceServiceGrpc.newBlockingStub(managedChannel);

        AnnouncementProto announcementProto = AnnouncementProto.newBuilder()
                .setPetOwnerEmail("sevastian@gmail.com")
                .setTimeStart(TimestampConverter.fromLocalDateTime(LocalDateTime.now()))
                .setTimeFinish(TimestampConverter.fromLocalDateTime(LocalDateTime.now().plusDays(3)))
                .setDescription("Nice")
                .setPostalCode("8700")
                .setPet(PetProto.newBuilder()
                        .setOwnerEmail("sevastian@gmail.com")
                        .setPetName("HUI_VAM")
                        .setPetType("Cat")
                        .setIsVaccinated(false)
                        .setDescription("miau miau maiu")
                        .setWeight(25)
                        .build())
                .build();
        AnnouncementProto announcementProtoResponse = announcementStub.createAnnouncement(announcementProto);
        System.out.println(announcementProtoResponse.getDescription());
//





        // Test update user
//        UserProto user = UserProto.newBuilder()
//                .setEmail("allan1@gmail.com")
//                .setPhone("000000000")
//                .setName("Allan ...")
//                .build();
//
//        try{
//            userStub.updateUser(user);
//        }catch (Exception e)
//        {
//            System.out.println(e.getMessage());

        // Test update announcement

//        AnnouncementProto announcementProto = AnnouncementProto.newBuilder()
//                .setId(1)
//                .setPostalCode("7424")
//                .setDescription("I was updated")
//                .build();
//
//        announcementStub.updateAnnouncement(announcementProto);




        // Test filter announcement
//        SearchAnnouncementProto searchAnnouncementProto = SearchAnnouncementProto.newBuilder()
//                .setPetType(StringValue.of("Dog"))
//                .build();
//        var filteredAnnouncements = announcementStub.findAnnouncements(searchAnnouncementProto);
//        System.out.println(filteredAnnouncements);





//         Test create user
//        UserProto user = UserProto.newBuilder()
//                .setEmail("allan6@gmail.com")
//                .setUsername("Allan")
//                .setType("CareTaker")
//                .setPassword("via123")
//                .build();
//        try {
//            UserProto response = userStub.createUser(user);
//            System.out.println(response.getEmail());
//        }
//        catch (Exception e)
//        {
//            System.out.println(e.getMessage());
//        }
//
//
//        System.out.println(announcementStub.findAnnouncements(null));


        //Test find user by email
//        UserProto userGet = userStub.findUser(FindUserProto.newBuilder().setEmail("allan@gmail.com").build());
//        System.out.println(userGet.getPassword());
//
//        //Test login
//        UserProto userLogIn = userStub.logIn(LoginUserProto.newBuilder().setEmail("allan@gmail.com").setPassword("via123").build());
//        System.out.println(userLogIn.getPassword());
//
//        //Test search by type
//        UsersProto users1 = userStub.searchUser(SearchUsersProto.newBuilder().setType("PetOwner").build());
//        System.out.println(users1.getUsersCount());
//        UsersProto users2 = userStub.searchUser(SearchUsersProto.newBuilder().setType("CareTaker").build());
//        System.out.println(users2.getUsersCount());
//
//
//
//        //Create announcement

//
//        UserProto user1 = userStub.findUser(FindUserProto.newBuilder().setEmail("allan@gmail.com").build());
//        System.out.println(user1.getPhone());
//


        managedChannel.shutdown();
    }
}
