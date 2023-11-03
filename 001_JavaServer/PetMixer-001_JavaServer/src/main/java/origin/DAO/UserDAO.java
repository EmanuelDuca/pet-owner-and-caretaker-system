package origin.DAO;

import origin.DAOInterfaces.UserDAOInterface;
import origin.File.FileServer;
import origin.shared.UserEntity;

import java.util.Collection;

public class UserDAO implements UserDAOInterface
{

    private FileServer database;
    public UserDAO() {
        database = FileServer.getInstance();
    }

    @Override
    public UserEntity registerUser(UserEntity userEntity)
    {
        database.AppendToFile(userEntity);
        return userEntity;
    }

    @Override
    public UserEntity loginUser(UserEntity userEntity) {
        return null;
    }

    @Override
    public UserEntity findUser(String email) {
        return database.getUsers()
                .stream()
                .filter(u -> u.getEmail().equals(email))
                .findAny().orElse(null);
    }

    @Override
    public void updateUserInformation(UserEntity userEntity) {

    }

    @Override
    public Collection<UserEntity> getAllUsers() {
        return null;
    }

    @Override
    public Collection<UserEntity> getUser(String searchField) {
        return null;
    }
}
