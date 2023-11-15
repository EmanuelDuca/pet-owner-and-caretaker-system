package dk.via.sep3.services;

import dk.via.sep3.DAO.UserDAO;
import dk.via.sep3.DAOInterfaces.UserDAOInterface;
import dk.via.sep3.mappers.UserMapper;
import dk.via.sep3.shared.UserEntity;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import origin.protobuf.UserProto;
import origin.protobuf.UserServiceGrpc;
import origin.protobuf.UsersProto;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

@GRpcService
public class UserService extends UserServiceGrpc.UserServiceImplBase
{
    @Autowired
    private UserDAOInterface userDAO;

    public UserService()
    {
    }

    @Transactional
    public void createUser(origin.protobuf.UserProto request, io.grpc.stub.StreamObserver<origin.protobuf.UserProto> responseObserver) {
        UserEntity user = new UserEntity(
                request.getEmail(),
                request.getUsername(),
                request.getPassword(),
                request.getAge(),
                request.getPhone(),
                request.getType()
        );
        if (userDAO.findUser(user.getEmail())==null)
        {
            UserEntity createdUser = userDAO.registerUser(user);
            responseObserver.onNext(UserMapper.mapProto(createdUser));
            responseObserver.onCompleted();
        }
        else
        {
            responseObserver.onError(new Exception("User with this email already exists"));
        }
    }
    @Transactional
    @Override
    public void logIn(origin.protobuf.LoginUserProto request, io.grpc.stub.StreamObserver<origin.protobuf.UserProto> responseObserver) {
        UserEntity loginUser = userDAO.loginUser(request.getEmail(), request.getPassword());
        if (loginUser != null)
        {
            responseObserver.onNext(UserMapper.mapProto(loginUser));
            responseObserver.onCompleted();
        }
        else
        {
            responseObserver.onError(new Exception("LogIn denied"));
        }

    }
    @Transactional
    @Override
    public void findUser(origin.protobuf.FindUserProto request, io.grpc.stub.StreamObserver<origin.protobuf.UserProto> responseObserver) {
        UserEntity userToFind = userDAO.findUser(request.getEmail());
        if (userToFind != null)
        {
            responseObserver.onNext(UserMapper.mapProto(userToFind));
            responseObserver.onCompleted();
        }
        else
        {
            responseObserver.onError(new Exception("There is no user with such an email"));
        }
    }
    @Transactional
    @Override
    public void searchUser(origin.protobuf.SearchUsersProto request, io.grpc.stub.StreamObserver<origin.protobuf.UsersProto> responseObserver) {
        Collection<UserEntity> users = userDAO.getUsers(request.getType());

        if (users.isEmpty()) {
            responseObserver.onError(new Exception("No such users"));
            return;
        }

        Collection<UserProto> userCollection = new ArrayList<>();

        for (var user : users)
        {
            userCollection.add(UserMapper.mapProto(user));
        }

        UsersProto usersItems = UsersProto.newBuilder().addAllUsers(userCollection).build();

        responseObserver.onNext(usersItems);
        responseObserver.onCompleted();

    }

    @Override
    public void updateUser(origin.protobuf.UserProto request, io.grpc.stub.StreamObserver<origin.protobuf.UserProto> responseObserver) {

    }

    @Override
    public void deleteUser(origin.protobuf.FindUserProto request, io.grpc.stub.StreamObserver<origin.protobuf.ResponseStatus> responseObserver) {

    }


}
