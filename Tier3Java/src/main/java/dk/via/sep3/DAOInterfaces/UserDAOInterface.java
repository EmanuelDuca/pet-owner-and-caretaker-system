package dk.via.sep3.DAOInterfaces;


import dk.via.sep3.shared.UserEntity;
import origin.protobuf.SearchAnnouncementProto;
import origin.protobuf.SearchUsersProto;

import java.util.Collection;

public interface UserDAOInterface {
    UserEntity registerUser(UserEntity userEntity);

    UserEntity loginUser(String email, String password);

    UserEntity findUser(String email);

    UserEntity updateUserInformation(UserEntity userEntity);

    String deleteUser(String email);

    Collection<UserEntity> getAllUsers();

    Collection<UserEntity> getUsers(String userType);
}
