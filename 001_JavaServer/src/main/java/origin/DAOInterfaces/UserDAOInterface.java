package origin.DAOInterfaces;


import origin.shared.UserEntity;

import java.util.Collection;

public interface UserDAOInterface
{
    UserEntity registerUser(UserEntity userEntity);

    UserEntity loginUser(UserEntity userEntity);

    UserEntity findUser(String email);

    void updateUserInformation(UserEntity userEntity);

    Collection<UserEntity> getAllUsers();

    Collection<UserEntity> getUser(String searchField);
}
