package dk.via.sep3.DAO;

import dk.via.sep3.DAOInterfaces.UserDAOInterface;
import dk.via.sep3.repository.UserRepository;
import dk.via.sep3.shared.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

@Repository
public class UserDAO implements UserDAOInterface {

    @Autowired
    private UserRepository userRepository;

    public UserDAO() {
    }

    @Override
    public UserEntity registerUser(UserEntity userEntity)
    {
        if ( !userRepository.existsById(userEntity.getEmail()))
        {
            userRepository.save(userEntity);
            return userEntity;
        }
        return null;
    }

    @Override
    public UserEntity loginUser(String email, String password)
    {
        if ( userRepository.existsById(email)) {
            if (userRepository.getReferenceById(email).getPassword().equals(password)) {
                return userRepository.getReferenceById(email);
            }
        }
        return null;
    }

    @Override
    public UserEntity findUser(String email)
    {
        if ( userRepository.existsById(email))
        {
            return userRepository.getReferenceById(email);
        }

        return null;
    }

    @Override
    public Collection<UserEntity> getUsers(String searchType)
    {
        Collection<UserEntity> users = userRepository.findAll();
        Collection<UserEntity> usersResult = new ArrayList<UserEntity>();
        for (var user : users)
        {
            if (user.getType().equals(searchType))
            {
                usersResult.add(user);
            }
        }
        return usersResult;
    }

    @Override
    public UserEntity updateUserInformation(UserEntity userEntity)
    {
        return null;
    }

    @Override
    public String deleteUser(String email)
    {
       if ( userRepository.existsById(email))
       {
           userRepository.deleteById(email);
           return "User Deleted";
       }
       else
       {
           return "User Not Found";
       }
    }

    @Override
    public Collection<UserEntity> getAllUsers()
    {
        return userRepository.findAll();
    }


}
