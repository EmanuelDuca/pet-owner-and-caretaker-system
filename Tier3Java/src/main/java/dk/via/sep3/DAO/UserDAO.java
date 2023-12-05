package dk.via.sep3.DAO;

import dk.via.sep3.DAOInterfaces.CaretakerScheduleRepository;
import dk.via.sep3.DAOInterfaces.UserDAOInterface;
import dk.via.sep3.model.PetEntity;
import dk.via.sep3.repository.PetRepository;
import dk.via.sep3.repository.UserRepository;
import dk.via.sep3.model.CalendarEntity;
import dk.via.sep3.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import static dk.via.sep3.model.CalendarEntity.*;

@Repository
public class UserDAO implements UserDAOInterface {

    private final UserRepository userRepository;
    private final PetRepository petRepository;
    private final CaretakerScheduleRepository caretakerScheduleRepository;

    @Autowired
    public UserDAO(UserRepository userRepository, PetRepository petRepository, CaretakerScheduleRepository caretakerScheduleRepository) {

        this.userRepository = userRepository;
        this.petRepository = petRepository;
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

        List<CalendarEntity> existingDatePeriods = caretakerScheduleRepository.findAll().stream()
                .filter(period -> period.getCareTaker().getEmail().equals(caretakerEmail))
                .toList();

        for (CalendarEntity existingPeriod : existingDatePeriods) {

            if (isPeriodWithinExisting(existingPeriod, startDate, endDate))
                return true;
            else if (isPeriodCoveringExisting(existingPeriod, startDate, endDate))
            {
                caretakerScheduleRepository.delete(existingPeriod);
            }
            else if (isPeriodOverlapping(existingPeriod, startDate, endDate))
            {
                if (startDate.isBefore(existingPeriod.getStartDate())) {
                    existingPeriod.setStartDate(startDate);
                }
                if (endDate.isAfter(existingPeriod.getEndDate())) {
                    existingPeriod.setEndDate(endDate);
                }

                caretakerScheduleRepository.save(existingPeriod);
                return true;
            }
        }

        caretakerScheduleRepository.save(new CalendarEntity(user, startDate, endDate));
        return true;
    }

    @Override
    @Transactional
    public boolean deleteDatePeriodFromScheduleOfCaretaker(String caretakerEmail, LocalDate startDate, LocalDate endDate) {
        var user = findUser(caretakerEmail);
        if (user == null || !user.getUserType().equals("CareTaker"))
            return false;

        List<CalendarEntity> existingDatePeriods = caretakerScheduleRepository.findAll().stream()
                .filter(period -> period.getCareTaker().getEmail().equals(caretakerEmail))
                .toList();

        for (CalendarEntity existingPeriod : existingDatePeriods)
        {

            if (isPeriodWithinExisting(existingPeriod, startDate, endDate))
            {
                // Split the date period into two segments
                CalendarEntity firstSegment = new CalendarEntity(existingPeriod.getCareTaker(), existingPeriod.getStartDate(), startDate.minusDays(1));
                CalendarEntity secondSegment = new CalendarEntity(existingPeriod.getCareTaker(), endDate.plusDays(1), existingPeriod.getEndDate());

                caretakerScheduleRepository.save(firstSegment);
                caretakerScheduleRepository.save(secondSegment);
            }
            else if (isPeriodCoveringExisting(existingPeriod, startDate, endDate))
            {
                caretakerScheduleRepository.delete(existingPeriod);
            }
            else if (isPeriodOverlapping(existingPeriod, startDate, endDate))
            {
                if (startDate.isAfter(existingPeriod.getStartDate())) {
                    existingPeriod.setEndDate(startDate.minusDays(1));
                }
                if (endDate.isBefore(existingPeriod.getEndDate())) {
                    existingPeriod.setStartDate(endDate.plusDays(1));
                }
                caretakerScheduleRepository.save(existingPeriod);
            }
        }

        return true;
    }




    @Override
    public Collection<CalendarEntity> getSchedule(String caretakerEmail, int month)
    {
        var user = findUser(caretakerEmail);
        if (user == null || !user.getUserType().equals("CareTaker"))
            return null;

        return caretakerScheduleRepository.findAll().stream()
                .filter(dp -> dp.getStartDate().getYear() == LocalDate.now().getYear())
                .filter(dp -> dp.getStartDate().getMonthValue() == month)
                .toList();
    }

    @Override
    public Collection<PetEntity> getPets(String email)
    {
        System.out.println(email);
        var user = findUser(email);
        System.out.println(user.getUserType());
        System.out.println(user.getEmail());
        if (user == null || !user.getUserType().equals("PetOwner")){
            return null;
        }



        return petRepository.findAll().stream()
                .filter(p -> p.getPetOwner().getEmail().equals(email)).toList();
    }


}
