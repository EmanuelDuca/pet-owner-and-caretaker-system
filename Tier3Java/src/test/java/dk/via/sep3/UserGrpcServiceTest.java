package dk.via.sep3;

import static org.junit.jupiter.api.Assertions.*;

import com.google.protobuf.StringValue;
import dk.via.sep3.mappers.UserMapper;
import dk.via.sep3.model.CalendarEntity;
import dk.via.sep3.model.PetEntity;
import dk.via.sep3.model.UserEntity;
import dk.via.sep3.utils.TimestampConverter;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import org.junit.jupiter.api.*;
import origin.protobuf.*;

import java.time.LocalDate;
import java.util.Collection;

public class UserGrpcServiceTest {

    private static UserServiceGrpc.UserServiceBlockingStub userStub;
    private static UserEntity careTaker;
    private static UserEntity petOwner;

    private static CalendarEntity existingPeriod;
    private static CalendarEntity givenPeriod;

    @BeforeAll
    public static void setUpClass() {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
        userStub = UserServiceGrpc.newBlockingStub(managedChannel);
        
        petOwner = new UserEntity("allan1@gmail.com", "Allan", "via123", "PetOwner");
        careTaker = new UserEntity("allan2@gmail.com", "Allan", "via123", "CareTaker");
    }


    @AfterEach
    @BeforeEach
    void cleanupTestData() {
        if(userExists(careTaker))
            deleteUser(careTaker);

        if(userExists(petOwner))
            deleteUser(petOwner);

        existingPeriod = new CalendarEntity();
        givenPeriod = new CalendarEntity();
        existingPeriod.setCareTaker(careTaker);
        givenPeriod.setCareTaker(careTaker);
    }

    private boolean userExists(UserEntity user) {
        FindUserProto userRequest = FindUserProto.newBuilder()
                .setEmail(user.getEmail())
                .build();
        try {
            userStub.findUser(userRequest);
            return true;
        } catch (StatusRuntimeException e) {
            return false;
        }
    }

    private UserEntity getUser(UserEntity user) {
        FindUserProto userRequest = FindUserProto.newBuilder()
                .setEmail(user.getEmail())
                .build();
        return UserMapper.mapToEntity(userStub.findUser(userRequest));
    }

    private UserEntity getUser(String userEmail) {
        FindUserProto userRequest = FindUserProto.newBuilder()
                .setEmail(userEmail)
                .build();
        return UserMapper.mapToEntity(userStub.findUser(userRequest));
    }

    private void deleteUser(UserEntity user) {
        FindUserProto userRequest = FindUserProto.newBuilder()
                .setEmail(user.getEmail())
                .build();
        userStub.deleteUser(userRequest);
    }

    private void createUser(UserEntity user) {
        var userProto = UserMapper.mapToProto(user);

        userStub.createUser(userProto);
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

    private void addDatePeriod(CalendarEntity datePeriod)
    {
        var protoDatePeriod = DatePeriodProto
                .newBuilder()
                .setCaretakerEmail(datePeriod.getCareTaker().getEmail())
                .setStartDate(TimestampConverter.fromLocalDate(datePeriod.getStartDate()))
                .setEndDate(TimestampConverter.fromLocalDate(datePeriod.getEndDate()))
                .build();

        userStub.addDatePeriodToScheduleOfCaretaker(protoDatePeriod);
    }

    private void deleteDatePeriod(CalendarEntity datePeriod)
    {
        var protoDatePeriod = DatePeriodProto
                .newBuilder()
                .setCaretakerEmail(datePeriod.getCareTaker().getEmail())
                .setStartDate(TimestampConverter.fromLocalDate(datePeriod.getStartDate()))
                .setEndDate(TimestampConverter.fromLocalDate(datePeriod.getEndDate()))
                .build();

        userStub.deleteDatePeriodFromScheduleOfCaretaker(protoDatePeriod);
    }

    private UserEntity loginUser(UserEntity user)
    {
        LoginUserProto userProto = LoginUserProto.newBuilder()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .build();

        return UserMapper.mapToEntity(userStub.logIn(userProto));
    }

    private Collection<CalendarEntity> getSchedule(int monthValue)
    {
        var protoRequest = FindCareTakerScheduleProto
                .newBuilder()
                .setMonth(monthValue)
                .setCaretakerEmail(careTaker.getEmail())
                .build();

        return userStub.getScheduleOfCaretaker(protoRequest)
                .getScheduleList()
                .stream().map(d -> new CalendarEntity(
                        getUser(d.getCaretakerEmail()),
                        TimestampConverter.toLocalDate(d.getStartDate()),
                        TimestampConverter.toLocalDate(d.getEndDate())
                        )
                ).toList();
    }

    private UserEntity updateUser(UserEntity userEntity)
    {
        var userProto = UserMapper.mapToProto(userEntity);

        return UserMapper.mapToEntity(userStub.updateUser(userProto));
    }

    private Collection<PetEntity> getPetsOfUser(UserEntity user)
    {
        FindUserProto userRequest = FindUserProto.newBuilder()
                .setEmail(user.getEmail())
                .build();
        var pets = userStub.searchPets(userRequest);
        return pets.getPetsList().stream().map(p -> new PetEntity(
                p.getId(),
                p.getPetName(),
                p.getPetType(),
                p.getWeight(),
                p.getIsVaccinated(),
                p.getDescription(),
                getUser(p.getOwnerEmail())
        )).toList();
    }

    private Collection<UserEntity> searchUsers(SearchUsersProto search)
    {
        return userStub.searchUsers(search)
                .getUsersList()
                .stream()
                .map(UserMapper::mapToEntity)
                .toList();
    }

    @Test
    void deleteUser_HappyCase_Test()
    {
        assertFalse(userExists(petOwner));
        createUser(petOwner);

        awaitCompletion(userExists(petOwner));

        assertTrue(userExists(petOwner));
        deleteUser(petOwner);
        assertFalse(userExists(petOwner));
    }

    @Test
    void deleteUser_BadCase_Test()
    {
        assertFalse(userExists(petOwner));
        assertThrows(StatusRuntimeException.class, () -> deleteUser(petOwner));
    }

    @Test
    void createPetOwner_HappyCase_Test() {
        assertFalse(userExists(careTaker));
        assertDoesNotThrow(() -> createUser(careTaker));

        awaitCompletion(userExists(careTaker));

        assertTrue(userExists(careTaker));
        var createdUser = getUser(careTaker);
        assertEquals(createdUser.getUserType(), careTaker.getUserType());
    }

    @Test
    void createCareTaker_HappyCase_Test() {
        assertFalse(userExists(petOwner));
        assertDoesNotThrow(() -> createUser(petOwner));

        awaitCompletion(userExists(petOwner));

        assertTrue(userExists(petOwner));
        var createdUser = getUser(petOwner);
        assertEquals(createdUser.getUserType(), petOwner.getUserType());
    }

    @Test
    void createUser_BadCase_Test()
    {
        assertFalse(userExists(petOwner));
        createUser(petOwner);

        awaitCompletion(userExists(petOwner));

        assertTrue(userExists(petOwner));
        assertThrows(StatusRuntimeException.class, () -> createUser(petOwner));
    }

    @Test
    void loginUser_HappyCase_Test()
    {
        assertFalse(userExists(careTaker));
        createUser(careTaker);
        awaitCompletion(userExists(careTaker));
        assertTrue(userExists(careTaker));
        assertDoesNotThrow(() -> loginUser(careTaker));
    }

    @Test
    void loginUser_BadCase_Test()
    {
        assertFalse(userExists(careTaker));
        assertThrows(StatusRuntimeException.class, () -> loginUser(careTaker));
    }

    @Test
    void updateUser_HappyCase_Test()
    {
        assertFalse(userExists(careTaker));
        UserEntity user = careTaker;
        createUser(user);
        awaitCompletion(userExists(user));
        assertTrue(userExists(user));

        user.setName("Allan");
        user.setAge(35);
        user.setPhone("12345678");

        var updatedUser = updateUser(user);
        assertEquals(user, updatedUser);
    }

    @Test
    void updateUser_BadCase_Test()
    {
        assertFalse(userExists(careTaker));
        UserEntity user = careTaker;

        user.setName("Allan");
        user.setAge(35);
        user.setPhone("12345678");

        assertThrows(StatusRuntimeException.class, () -> updateUser(user));
    }

    @Test
    void searchUsers_Test()
    {
        assertFalse(userExists(careTaker));
        assertFalse(userExists(petOwner));

        createUser(careTaker);
        createUser(petOwner);

        awaitCompletion(userExists(careTaker));

        assertTrue(userExists(careTaker));
        assertTrue(userExists(petOwner));


        SearchUsersProto searchProto = SearchUsersProto
                .newBuilder()
                .setType(StringValue.of(careTaker.getUserType()))
                .build();

        searchUsers(searchProto).forEach(u -> assertEquals(u.getUserType(), careTaker.getUserType()));

        searchProto = SearchUsersProto
                .newBuilder()
                .setType(StringValue.of(petOwner.getUserType()))
                .build();

        searchUsers(searchProto).forEach(u -> assertEquals(u.getUserType(), petOwner.getUserType()));
    }

    @Test
    void addDatePeriodToScheduleOfCaretaker_NoConflictsWithExisting_HappyCase_Test()
    {
        createUser(careTaker);
        awaitCompletion(userExists(careTaker));
        assertTrue(userExists(careTaker));

        assertTrue(getSchedule(LocalDate.now().getMonthValue()).isEmpty());

        existingPeriod.setStartDate(LocalDate.now().withDayOfMonth(3));
        existingPeriod.setEndDate(LocalDate.now().withDayOfMonth(12));
        assertDoesNotThrow(() -> addDatePeriod(existingPeriod));
        assertEquals(1, getSchedule(LocalDate.now().getMonthValue()).size());


        givenPeriod.setStartDate(LocalDate.now().withDayOfMonth(16));
        givenPeriod.setEndDate(LocalDate.now().withDayOfMonth(24));
        assertDoesNotThrow(() -> addDatePeriod(givenPeriod));
        assertEquals(2, getSchedule(LocalDate.now().getMonthValue()).size());

        deleteDatePeriod(existingPeriod);
        deleteDatePeriod(givenPeriod);
        assertEquals(0, getSchedule(LocalDate.now().getMonthValue()).size());
    }

    @Test
    void addDatePeriodToScheduleOfCaretaker_GivenDatePeriodOverlapsExisting_HappyCase_Test()
    {
        createUser(careTaker);
        awaitCompletion(userExists(careTaker));
        assertTrue(userExists(careTaker));

        assertTrue(getSchedule(LocalDate.now().getMonthValue()).isEmpty());

        existingPeriod.setStartDate(LocalDate.now().withDayOfMonth(3));
        existingPeriod.setEndDate(LocalDate.now().withDayOfMonth(18));
        assertDoesNotThrow(() -> addDatePeriod(existingPeriod));
        assertEquals(1, getSchedule(LocalDate.now().getMonthValue()).size());


        givenPeriod.setStartDate(LocalDate.now().withDayOfMonth(9));
        givenPeriod.setEndDate(LocalDate.now().withDayOfMonth(24));
        assertDoesNotThrow(() -> addDatePeriod(givenPeriod));
        assertEquals(1, getSchedule(LocalDate.now().getMonthValue()).size());

        var resultPeriod = getSchedule(LocalDate.now().getMonthValue()).stream()
                .findFirst().orElseThrow();
        assertEquals(3, resultPeriod.getStartDate().getDayOfMonth());
        assertEquals(24, resultPeriod.getEndDate().getDayOfMonth());

        deleteDatePeriod(resultPeriod);
        assertEquals(0, getSchedule(LocalDate.now().getMonthValue()).size());
    }

    @Test
    void addDatePeriodToScheduleOfCaretaker_GivenDatePeriodCoversExisting_HappyCase_Test()
    {
        createUser(careTaker);
        awaitCompletion(userExists(careTaker));
        assertTrue(userExists(careTaker));

        assertTrue(getSchedule(LocalDate.now().getMonthValue()).isEmpty());

        existingPeriod.setStartDate(LocalDate.now().withDayOfMonth(3));
        existingPeriod.setEndDate(LocalDate.now().withDayOfMonth(12));
        assertDoesNotThrow(() -> addDatePeriod(existingPeriod));
        assertEquals(1, getSchedule(LocalDate.now().getMonthValue()).size());


        givenPeriod.setStartDate(LocalDate.now().withDayOfMonth(1));
        givenPeriod.setEndDate(LocalDate.now().withDayOfMonth(14));
        assertDoesNotThrow(() -> addDatePeriod(givenPeriod));
        assertEquals(1, getSchedule(LocalDate.now().getMonthValue()).size());

        var resultPeriod = getSchedule(LocalDate.now().getMonthValue()).stream()
                .findFirst().orElseThrow();
        assertEquals(1, resultPeriod.getStartDate().getDayOfMonth());
        assertEquals(14, resultPeriod.getEndDate().getDayOfMonth());

        deleteDatePeriod(givenPeriod);
        assertEquals(0, getSchedule(LocalDate.now().getMonthValue()).size());
    }

    @Test
    void addDatePeriodToScheduleOfCaretaker_BadCase_Test()
    {
        createUser(petOwner);
        awaitCompletion(userExists(petOwner));
        assertTrue(userExists(petOwner));

        existingPeriod.setStartDate(LocalDate.now().withDayOfMonth(3));
        existingPeriod.setEndDate(LocalDate.now().withDayOfMonth(12));

        assertThrows(StatusRuntimeException.class, () -> addDatePeriod(existingPeriod));
    }

    @Test
    void deleteDatePeriodFromScheduleOfCaretaker_NoConflictsWithExisting_HappyCase_Test()
    {
        createUser(careTaker);
        awaitCompletion(userExists(careTaker));
        assertTrue(userExists(careTaker));

        assertTrue(getSchedule(LocalDate.now().getMonthValue()).isEmpty());

        existingPeriod.setStartDate(LocalDate.now().withDayOfMonth(3));
        existingPeriod.setEndDate(LocalDate.now().withDayOfMonth(12));
        assertDoesNotThrow(() -> addDatePeriod(existingPeriod));
        assertEquals(1, getSchedule(LocalDate.now().getMonthValue()).size());

        deleteDatePeriod(existingPeriod);
        assertEquals(0, getSchedule(LocalDate.now().getMonthValue()).size());
    }

    @Test
    void deleteDatePeriodFromScheduleOfCaretaker_GivenDatePeriodOverlapsExisting_HappyCase_Test()
    {
        createUser(careTaker);
        awaitCompletion(userExists(careTaker));
        assertTrue(userExists(careTaker));

        assertTrue(getSchedule(LocalDate.now().getMonthValue()).isEmpty());

        existingPeriod.setStartDate(LocalDate.now().withDayOfMonth(3));
        existingPeriod.setEndDate(LocalDate.now().withDayOfMonth(12));
        assertDoesNotThrow(() -> addDatePeriod(existingPeriod));
        assertEquals(1, getSchedule(LocalDate.now().getMonthValue()).size());


        givenPeriod.setStartDate(LocalDate.now().withDayOfMonth(6));
        givenPeriod.setEndDate(LocalDate.now().withDayOfMonth(21));
        deleteDatePeriod(givenPeriod);

        var resultPeriod = getSchedule(LocalDate.now().getMonthValue()).stream()
                .findFirst().orElseThrow();
        assertEquals(3, resultPeriod.getStartDate().getDayOfMonth());
        assertEquals(5, resultPeriod.getEndDate().getDayOfMonth());
    }

    @Test
    void deleteDatePeriodFromScheduleOfCaretaker_BadCase_Test()
    {
        createUser(petOwner);
        awaitCompletion(userExists(petOwner));
        assertTrue(userExists(petOwner));

        existingPeriod.setStartDate(LocalDate.now().withDayOfMonth(3));
        existingPeriod.setEndDate(LocalDate.now().withDayOfMonth(12));

        assertThrows(StatusRuntimeException.class, () -> deleteDatePeriod(existingPeriod));
    }

    @Test
    void getSchedule_HappyCase_Test()
    {
        createUser(careTaker);
        awaitCompletion(userExists(careTaker));
        assertTrue(userExists(careTaker));

        existingPeriod.setStartDate(LocalDate.now().withMonth(3));
        existingPeriod.setEndDate(LocalDate.now().withMonth(3).plusDays(5));
        addDatePeriod(existingPeriod);

        givenPeriod.setStartDate(LocalDate.now().withMonth(4));
        givenPeriod.setEndDate(LocalDate.now().withMonth(4).plusDays(5));
        addDatePeriod(existingPeriod);

        assertEquals(1, getSchedule(3).size());
    }

//    @Test
//    void getPets_HappyCase_Test()
//    {
//        createUser(petOwner);
//        awaitCompletion(userExists(careTaker));
//        assertTrue(userExists(careTaker));
//
//        existingPeriod.setStartDate(LocalDate.now().withMonth(3));
//        existingPeriod.setEndDate(LocalDate.now().withMonth(3).plusDays(5));
//        addDatePeriod(existingPeriod);
//
//        givenPeriod.setStartDate(LocalDate.now().withMonth(4));
//        givenPeriod.setEndDate(LocalDate.now().withMonth(4).plusDays(5));
//        addDatePeriod(existingPeriod);
//
//        assertEquals(1, getSchedule(3).size());
//    }
}
