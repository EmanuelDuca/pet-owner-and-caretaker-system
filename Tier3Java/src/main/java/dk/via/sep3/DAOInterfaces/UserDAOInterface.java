package dk.via.sep3.DAOInterfaces;


import dk.via.sep3.shared.CalendarEntity;
import dk.via.sep3.shared.UserEntity;

import java.time.LocalDate;
import java.util.Collection;

public interface UserDAOInterface {
    UserEntity registerUser(UserEntity userEntity);

    UserEntity loginUser(String email, String password);

    UserEntity findUser(String email);

    UserEntity updateUserInformation(UserEntity userEntity);

    String deleteUser(String email);

    Collection<UserEntity> getAllUsers();

    Collection<UserEntity> getUsers(String userType);

    boolean addDatePeriodToScheduleOfCaretaker(String caretakerEmail, LocalDate startDate, LocalDate endDate);

    boolean deleteDatePeriodFromScheduleOfCaretaker(String caretakerEmail, LocalDate startDate, LocalDate endDate);
    Collection<CalendarEntity> getSchedule(String caretakerEmail, int month);
}
