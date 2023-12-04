package dk.via.sep3.services;

import com.google.common.base.Strings;
import dk.via.sep3.DAOInterfaces.UserDAOInterface;
import dk.via.sep3.mappers.UserMapper;
import dk.via.sep3.model.UserEntity;
import dk.via.sep3.utils.TimestampConverter;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import origin.protobuf.*;
import origin.protobuf.FindUserProto;
import origin.protobuf.LoginUserProto;
import origin.protobuf.UserProto;
import origin.protobuf.Void;

import javax.transaction.Transactional;
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


    @Override
    @Transactional
    public void createUser(UserProto request, StreamObserver<UserProto> responseObserver) {
        UserEntity user = UserMapper.mapToEntity(request);

        if (userDAO.findUser(user.getEmail()) == null)
        {
            UserEntity createdUser = userDAO.registerUser(user);
            System.out.println(createdUser.getUserType());
            responseObserver.onNext(UserMapper.mapToProto(createdUser));
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
            responseObserver.onNext(UserMapper.mapToProto(loginUser));
            responseObserver.onCompleted();
            return;
        }

        responseObserver.onError(GrpcError.constructException("Username or password are incorrect."));

    }
    @Override
    @Transactional
    public void findUser(FindUserProto request, StreamObserver<UserProto> responseObserver) {
        UserEntity userToFind = userDAO.findUser(request.getEmail());
        if (userToFind != null)
        {
            responseObserver.onNext(UserMapper.mapToProto(userToFind));
            responseObserver.onCompleted();
            return;
        }

        responseObserver.onError(GrpcError.constructException("There is no user with such an email"));


    }
    @Override
    @Transactional
    public void searchUsers(SearchUsersProto request, StreamObserver<UsersProto> responseObserver) {
        Collection<UserEntity> users = userDAO.getUsers(request.getType().getValue());

        if (users.isEmpty()) {
            responseObserver.onError(GrpcError.constructException("No such users"));
            return;
        }

        var filteredUsers = users.stream().map(UserMapper::mapToProto).toList();

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

        if(!Strings.isNullOrEmpty(request.getPassword()))
            user.setPassword(request.getPassword());


        var updatedUser = userDAO.updateUserInformation(user);
        if(updatedUser == null)
        {
            responseObserver.onError(GrpcError.constructException("User was not updated."));
            return;
        }

        responseObserver.onNext(UserMapper.mapToProto(updatedUser));
        responseObserver.onCompleted();
    }

    @Override
    public void deleteUser(FindUserProto request, StreamObserver<Void> responseObserver)
    {
        if(userDAO.findUser(request.getEmail()) == null)
        {
            responseObserver.onError(GrpcError.constructException("User was not deleted, because it doesn't exist."));
            return;
        }

        userDAO.deleteUser(request.getEmail());
        responseObserver.onNext(Void.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    @Transactional
    public void addDatePeriodToScheduleOfCaretaker(DatePeriodOfCaretaker request, StreamObserver<Void> responseObserver)
    {
        boolean isAdded = userDAO.addDatePeriodToScheduleOfCaretaker(
                request.getCaretakerEmail(),
                TimestampConverter.toLocalDate(request.getStartDate()),
                TimestampConverter.toLocalDate(request.getEndDate())
                );

        if(!isAdded)
        {
            responseObserver.onError(GrpcError.constructException("Time period was not added to the schedule"));
            return;
        }

        responseObserver.onNext(Void.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void deleteDatePeriodToScheduleOfCaretaker(DatePeriodOfCaretaker request, StreamObserver<Void> responseObserver)
    {
        boolean isDeleted = userDAO.deleteDatePeriodFromScheduleOfCaretaker(
                request.getCaretakerEmail(),
                TimestampConverter.toLocalDate(request.getStartDate()),
                TimestampConverter.toLocalDate(request.getEndDate())
        );

        if(!isDeleted)
        {
            responseObserver.onError(GrpcError.constructException("Time period was not deleted from the schedule"));
            return;
        }

        responseObserver.onNext(Void.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    @Transactional
    public void getScheduleOfCaretaker(CareTakerScheduleRequest request, StreamObserver<CaretakerSchedule> responseObserver)
    {
        var result = userDAO.getSchedule(request.getCaretakerEmail(), request.getMonth());

        if(result == null)
        {
            responseObserver.onError(GrpcError.constructException("Can't get schedule"));
            return;
        }

        responseObserver.onNext(CaretakerSchedule.newBuilder()
                .addAllSchedule(
                        result.stream().map(dp ->
                            DatePeriodOfCaretaker.newBuilder()
                                    .setCaretakerEmail(dp.getCareTaker().getEmail())
                                    .setStartDate(TimestampConverter.fromLocalDate(dp.getStartDate()))
                                    .setEndDate(TimestampConverter.fromLocalDate(dp.getEndDate()))
                                    .build()
                        ).toList()
                )
                .build()
        );
        responseObserver.onCompleted();
    }
}
