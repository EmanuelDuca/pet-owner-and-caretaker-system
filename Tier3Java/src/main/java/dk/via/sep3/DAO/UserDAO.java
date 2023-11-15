package dk.via.sep3.DAO;

import dk.via.sep3.DAOInterfaces.UserDAOInterface;
import dk.via.sep3.repository.UserRepository;
import dk.via.sep3.shared.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Repository
public class UserDAO implements UserDAOInterface {

    @Autowired
    private  UserRepository userRepository;

    public UserDAO() {

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
                .filter(u -> u.getType().equals(searchType))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public UserEntity updateUserInformation(UserEntity userEntity)
    {
        return null;
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


}
