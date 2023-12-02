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

import static dk.via.sep3.shared.CaretakerDatePeriod.*;

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
    @Transactional
    public boolean addDatePeriodToScheduleOfCaretaker(String caretakerEmail, LocalDate startDate, LocalDate endDate) {
        var user = findUser(caretakerEmail);
        if (user == null || !user.getUserType().equals("CareTaker"))
            return false;

        List<CaretakerDatePeriod> existingDatePeriods = caretakerScheduleRepository.findAll().stream()
                .filter(period -> period.getCareTaker().getEmail().equals(caretakerEmail))
                .toList();

        for (CaretakerDatePeriod existingPeriod : existingDatePeriods) {

            if (isPeriodWithinExisting(existingPeriod, startDate, endDate))
                return true;
            else if (isPeriodCoveringExisting(existingPeriod, startDate, endDate))
            {
                caretakerScheduleRepository.delete(existingPeriod);
            }
            else if (isPeriodOverlapping(existingPeriod, startDate, endDate))
            {
                handleOverlappingPeriod(existingPeriod, startDate, endDate);
                caretakerScheduleRepository.save(existingPeriod);
            }
        }

        caretakerScheduleRepository.save(new CaretakerDatePeriod(user, startDate, endDate));
        return true;
    }

    @Override
    @Transactional
    public boolean deleteDatePeriodFromScheduleOfCaretaker(String caretakerEmail, LocalDate startDate, LocalDate endDate) {
        var user = findUser(caretakerEmail);
        if (user == null || !user.getUserType().equals("CareTaker"))
            return false;

        List<CaretakerDatePeriod> existingDatePeriods = caretakerScheduleRepository.findAll().stream()
                .filter(period -> period.getCareTaker().getEmail().equals(caretakerEmail))
                .toList();

        for (CaretakerDatePeriod existingPeriod : existingDatePeriods)
        {

            if (isPeriodWithinExisting(existingPeriod, startDate, endDate))
            {
                // Split the date period into two segments
                CaretakerDatePeriod firstSegment = new CaretakerDatePeriod(existingPeriod.getCareTaker(), existingPeriod.getStartDate(), startDate.minusDays(1));
                CaretakerDatePeriod secondSegment = new CaretakerDatePeriod(existingPeriod.getCareTaker(), endDate.plusDays(1), existingPeriod.getEndDate());

                caretakerScheduleRepository.save(firstSegment);
                caretakerScheduleRepository.save(secondSegment);
            }
            else if (isPeriodCoveringExisting(existingPeriod, startDate, endDate))
            {
                caretakerScheduleRepository.delete(existingPeriod);
            }
            else if (isPeriodOverlapping(existingPeriod, startDate, endDate))
            {
                handleOverlappingPeriod(existingPeriod, startDate, endDate);
                caretakerScheduleRepository.save(existingPeriod);
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
