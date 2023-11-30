package dk.via.sep3;

import static org.junit.jupiter.api.Assertions.*;

import dk.via.sep3.mappers.UserMapper;
import dk.via.sep3.shared.UserEntity;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import org.junit.jupiter.api.*;
import origin.protobuf.FindUserProto;
import origin.protobuf.UserProto;
import origin.protobuf.UserServiceGrpc;

public class UserGrpcServiceTest {

    private static UserServiceGrpc.UserServiceBlockingStub userStub;

    @BeforeAll
    public static void setUpClass() {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
        userStub = UserServiceGrpc.newBlockingStub(managedChannel);
    }


    @AfterEach
    @BeforeEach
    void cleanupTestData() {
        if(userExists("allan1@gmail.com"))
            deleteUser("allan1@gmail.com");

        if(userExists("allan2@gmail.com"))
            deleteUser("allan2@gmail.com");
    }

    private boolean userExists(String userEmail) {
        FindUserProto userRequest = FindUserProto.newBuilder()
                .setEmail(userEmail)
                .build();
        try {
            userStub.findUser(userRequest);
            return true;
        } catch (StatusRuntimeException e) {
            return false;
        }
    }

    private UserEntity getUser(String userEmail) {
        FindUserProto userRequest = FindUserProto.newBuilder()
                .setEmail(userEmail)
                .build();
        return UserMapper.mapToEntity(userStub.findUser(userRequest));
    }

    private void deleteUser(String userEmail) {
        FindUserProto userRequest = FindUserProto.newBuilder()
                .setEmail(userEmail)
                .build();
        userStub.deleteUser(userRequest);
    }

    private void createUser(String email, String type) {
        UserProto user = UserProto.newBuilder()
                .setEmail(email)
                .setUsername("Allan")
                .setType(type)
                .setPassword("via123")
                .build();

        userStub.createUser(user);
    }

    private void awaitCompletion(boolean condition)
    {
        int maxAttempts = 10;
        int attempt = 0;
        while (attempt < maxAttempts) {
            if (condition) {
                break;
            }
            try
            {
                Thread.sleep(20);
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
            attempt++;
        }
    }

    @Test
    void deleteUser_HappyCase_Test()
    {
        String email = "allan2@gmail.com";
        assertFalse(userExists(email));
        createUser(email, "CareTaker");

        awaitCompletion(userExists(email));

        assertTrue(userExists(email));
        deleteUser(email);
        assertFalse(userExists(email));
    }

    @Test
    void deleteUser_BadCase_Test()
    {
        String email = "allan2@gmail.com";
        assertFalse(userExists(email));
        assertThrows(StatusRuntimeException.class, () -> deleteUser(email));
    }

    @Test
    void createPetOwner_HappyCase_Test() {
        String email = "allan1@gmail.com";
        String userType = "PetOwner";
        assertFalse(userExists(email));
        assertDoesNotThrow(() -> createUser(email, userType));

        awaitCompletion(userExists(email));

        assertTrue(userExists(email));
        assertEquals(getUser(email).getUserType(), userType);
    }

    @Test
    void createCareTaker_HappyCase_Test() {
        String email = "allan2@gmail.com";
        String userType = "CareTaker";
        assertFalse(userExists(email));
        assertDoesNotThrow(() -> createUser(email, userType));

        awaitCompletion(userExists(email));

        assertTrue(userExists(email));
        assertEquals(getUser(email).getUserType(), userType);
    }

    @Test
    void createUser_BadCase_Test()
    {
        String email = "allan2@gmail.com";
        String userType = "CareTaker";
        assertFalse(userExists(email));
        createUser(email, userType);

        awaitCompletion(userExists(email));

        assertTrue(userExists(email));
        assertThrows(StatusRuntimeException.class, () -> createUser(email, userType));
    }

    @Test
    void loginUser_HappyCase_Test()
    {
        fail();
    }

    @Test
    void loginUser_BadCase_Test()
    {
        fail();
    }

    @Test
    void updateUser_HappyCase_Test()
    {
        fail();
    }

    @Test
    void updateUser_BadCase_Test()
    {
        fail();
    }

    @Test
    void searchUsers_Test()
    {
        fail();
    }

    @Test
    void addDatePeriodToScheduleOfCaretaker_HappyCase_Test()
    {
        fail();
    }

    @Test
    void addDatePeriodToScheduleOfCaretaker_BadCase_Test()
    {
        fail();
    }

    @Test
    void deleteDatePeriodFromScheduleOfCaretaker_HappyCase_Test()
    {
        fail();
        // Todo add more tests to test all possible cases with date periods
    }

    @Test
    void deleteDatePeriodFromScheduleOfCaretaker_BadCase_Test()
    {
        fail();
    }

    @Test
    void getSchedule_HappyCase_Test()
    {
        fail();
    }

    @Test
    void getSchedule_BadCase_Test()
    {
        fail();
    }
}
