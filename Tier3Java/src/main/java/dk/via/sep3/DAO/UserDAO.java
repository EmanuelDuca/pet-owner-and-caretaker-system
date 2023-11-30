package dk.via.sep3.DAO;

import dk.via.sep3.DAOInterfaces.CaretakerScheduleRepository;
import dk.via.sep3.DAOInterfaces.UserDAOInterface;
import dk.via.sep3.repository.UserRepository;
import dk.via.sep3.shared.CaretakerDatePeriod;
import dk.via.sep3.shared.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserDAO implements UserDAOInterface {

    private final UserRepository userRepository;
    private final CaretakerScheduleRepository caretakerScheduleRepository;

    @Autowired
    public UserDAO(UserRepository userRepository, CaretakerScheduleRepository caretakerScheduleRepository) {

        this.userRepository = userRepository;
        this.caretakerScheduleRepository = caretakerScheduleRepository;
    }

    @Override
    public UserEntity registerUser(UserEntity userEntity)
    {
        if (userRepository.existsById(userEntity.getEmail()))
            return null;

        userRepository.save(userEntity);
        return userEntity;
    }

    @Override
    public UserEntity loginUser(String email, String password)
    {
        if (!userRepository.existsById(email))
            return null;

        if(!userRepository.getReferenceById(email).getPassword().equals(password))
            return null;

        return userRepository.getReferenceById(email);
    }


    @Override
    public UserEntity findUser(String email)
    {
        if (!userRepository.existsById(email))
            return null;

        return userRepository.getReferenceById(email);
    }

    @Override
    public Collection<UserEntity> getUsers(String searchType)
    {
        return userRepository.findAll()
                .stream()
                .filter(u -> searchType.equals(u.getUserType()))
                .toList();
    }

    @Override
    public UserEntity updateUserInformation(UserEntity userEntity)
    {
        return userRepository.save(userEntity);
    }

    @Override
    public String deleteUser(String email)
    {
        if (!userRepository.existsById(email))
           return "User Not Found";


        userRepository.deleteById(email);
        return "User Deleted";
    }

    @Override
    public Collection<UserEntity> getAllUsers()
    {
        return userRepository.findAll();
    }

    @Override
    public boolean addDatePeriodToScheduleOfCaretaker(String caretakerEmail, LocalDate startDate, LocalDate endDate)
    {
        var user = findUser(caretakerEmail);
        if(user == null || !user.getUserType().equals("CareTaker"))
            return false;

        caretakerScheduleRepository.save(new CaretakerDatePeriod(user, startDate, endDate));
        return true;
    }

    @Override
    public boolean deleteDatePeriodFromScheduleOfCaretaker(String caretakerEmail, LocalDate startDate, LocalDate endDate)
    {
        var user = findUser(caretakerEmail);
        if (user == null || !user.getUserType().equals("CareTaker"))
            return false;

        List<CaretakerDatePeriod> datePeriods = caretakerScheduleRepository.findAll().stream()
                .filter(period -> period.getCareTaker().getEmail().equals(caretakerEmail))
                .filter(period -> (period.getStartDate().isAfter(startDate) || period.getStartDate().isEqual(startDate))
                        && (period.getEndDate().isBefore(endDate) || period.getEndDate().isEqual(endDate)))
                .toList();

        for (CaretakerDatePeriod datePeriod : datePeriods)
        {
            LocalDate periodStartDate = datePeriod.getStartDate();
            LocalDate periodEndDate = datePeriod.getEndDate();

            if (periodStartDate.isBefore(startDate) && periodEndDate.isAfter(endDate))
            {
                // Split the date period into two segments
                CaretakerDatePeriod firstSegment = new CaretakerDatePeriod(datePeriod.getCareTaker(), periodStartDate, startDate.minusDays(1));
                CaretakerDatePeriod secondSegment = new CaretakerDatePeriod(datePeriod.getCareTaker(), endDate.plusDays(1), periodEndDate);

                caretakerScheduleRepository.save(firstSegment);
                caretakerScheduleRepository.save(secondSegment);
            } else if (periodStartDate.isBefore(startDate) && periodEndDate.isBefore(endDate))
            {
                // Adjust the end date of the date period
                datePeriod.setEndDate(startDate.minusDays(1));
                caretakerScheduleRepository.save(datePeriod);
            } else if (periodStartDate.isAfter(startDate) && periodEndDate.isAfter(endDate))
            {
                // Adjust the start date of the date period
                datePeriod.setStartDate(endDate.plusDays(1));
                caretakerScheduleRepository.save(datePeriod);
            } else if (periodStartDate.isEqual(startDate) && periodEndDate.isEqual(endDate))
            {
                // Delete the entire date period
                caretakerScheduleRepository.delete(datePeriod);
            }
        }

        return true;
    }

    @Override
    public Collection<CaretakerDatePeriod> getSchedule(String caretakerEmail, int month)
    {
        var user = findUser(caretakerEmail);
        if (user == null || !user.getUserType().equals("CareTaker"))
            return null;

        return caretakerScheduleRepository.findAll().stream()
                .filter(dp -> dp.getStartDate().getMonthValue() == month)
                .toList();
    }


}
