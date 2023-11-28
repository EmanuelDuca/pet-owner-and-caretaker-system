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
        UserEntity user = UserMapper.mapToShared(request);
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
        Collection<UserEntity> users = userDAO.getUsers(request.getType().getValue());

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

        if(request.hasName())
            user.setName(request.getName().getValue());

        if(request.hasAge())
            user.setAge(request.getAge().getValue());

        if(request.hasPhone())
            user.setPhone(request.getPhone().getValue());

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
