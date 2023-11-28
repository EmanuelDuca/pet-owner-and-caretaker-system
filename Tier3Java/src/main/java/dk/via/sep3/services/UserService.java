package dk.via.sep3.services;

import com.google.common.base.Strings;
import dk.via.sep3.DAOInterfaces.UserDAOInterface;
import dk.via.sep3.mappers.UserMapper;
import dk.via.sep3.shared.UserEntity;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import origin.protobuf.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

@GRpcService
public class UserService extends UserServiceGrpc.UserServiceImplBase
{
    private final UserDAOInterface userDAO;

    @Autowired
    public UserService(UserDAOInterface userDAO)
    {
        this.userDAO = userDAO;
    }


    public void createUser(UserProto request, StreamObserver<UserProto> responseObserver) {
        UserEntity user = new UserEntity(
                request.getEmail(),
                request.getUsername(),
                request.getPassword(),
                request.getAge(),
                request.getPhone(),
                request.getType()
        );
        if (userDAO.findUser(user.getEmail()) == null)
        {
            UserEntity createdUser = userDAO.registerUser(user);
            responseObserver.onNext(UserMapper.mapProto(createdUser));
            responseObserver.onCompleted();
            return;
        }


        responseObserver.onError(GrpcError.constructException("User with this email already exists"));
    }

    @Transactional
    @Override
    public void logIn(LoginUserProto request, StreamObserver<UserProto> responseObserver) {
        UserEntity loginUser = userDAO.loginUser(request.getEmail(), request.getPassword());
        if (loginUser != null)
        {
            responseObserver.onNext(UserMapper.mapProto(loginUser));
            responseObserver.onCompleted();
            return;
        }

        responseObserver.onError(GrpcError.constructException("Username or password are incorrect."));

    }
    @Transactional
    @Override
    public void findUser(FindUserProto request, StreamObserver<UserProto> responseObserver) {
        UserEntity userToFind = userDAO.findUser(request.getEmail());
        if (userToFind != null)
        {
            responseObserver.onNext(UserMapper.mapProto(userToFind));
            responseObserver.onCompleted();
            return;
        }

        responseObserver.onError(GrpcError.constructException("There is no user with such an email"));


    }
    @Override
    @Transactional
    public void searchUser(SearchUsersProto request, StreamObserver<UsersProto> responseObserver) {
        Collection<UserEntity> users = userDAO.getUsers(request.getType());

        if (users.isEmpty()) {
            responseObserver.onError(GrpcError.constructException("No such users"));
            return;
        }

        var filteredUsers = users.stream().map(UserMapper::mapProto).toList();

        UsersProto usersItems = UsersProto.newBuilder().addAllUsers(filteredUsers).build();

        responseObserver.onNext(usersItems);
        responseObserver.onCompleted();

    }

    @Override
    @Transactional
    public void updateUser(UserProto request, StreamObserver<UserProto> responseObserver) {
        UserEntity user = userDAO.findUser(request.getEmail());

        if(user == null)
        {
            responseObserver.onError(GrpcError.constructException("User with email " + request.getEmail() + " is not found"));
            return;
        }

        if(!Strings.isNullOrEmpty(request.getName()))
            user.setName(request.getName());

        if(request.getAge() != 0)
            user.setAge(request.getAge());

        if(!Strings.isNullOrEmpty(request.getPhone()))
            user.setPhone(request.getPhone());

        if(!Strings.isNullOrEmpty(request.getUsername()))
            user.setUsername(request.getUsername());


        var updatedUser = userDAO.updateUserInformation(user);
        if(updatedUser == null)
        {
            responseObserver.onError(GrpcError.constructException("User was not updated."));
            return;
        }

        responseObserver.onNext(UserMapper.mapProto(updatedUser));
        responseObserver.onCompleted();
    }

    @Override
    public void deleteUser(FindUserProto request, StreamObserver<ResponseStatus> responseObserver) {

    }


}
