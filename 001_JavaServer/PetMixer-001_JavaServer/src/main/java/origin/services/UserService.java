package origin.services;

import io.grpc.stub.StreamObserver;
import origin.DAO.UserDAO;
import origin.DAOInterfaces.UserDAOInterface;
import origin.mappers.UserMapper;
import origin.protobuf.LoginUserProto;
import origin.protobuf.SearchFieldProto;
import origin.protobuf.UserProto;
import origin.protobuf.UserServiceGrpc;
import origin.shared.CaretakerEntity;
import origin.shared.PetOwnerEntity;
import origin.shared.UserEntity;



public class UserService extends UserServiceGrpc.UserServiceImplBase {

    private final UserDAOInterface userDAO;
    public UserService()
    {
        userDAO = new UserDAO();
    }

//    @Override
//    public void loginUser(LoginUserProto request, StreamObserver<UserProto> responseObserver)
//    {
//        UserEntity petOwner = new UserEntity(request.getEmail(), request.getPassword());
//        UserEntity loginUser = userDAO.loginUser(petOwner);
//        responseObserver.onNext(UserMapper.mapProto(loginUser));
//        responseObserver.onCompleted();
//    }

    @Override
    public void createUser(UserProto request, StreamObserver<UserProto> responseObserver)
    {
        UserEntity petOwner = switch (request.getType())
        {
            case "PetOwner" -> new PetOwnerEntity(
                    request.getUsername(),
                    request.getPassword(),
                    request.getAge(),
                    request.getPhone(),
                    request.getEmail());
            case "CareTaker" -> new CaretakerEntity(
                    request.getUsername(),
                    request.getPassword(),
                    request.getAge(),
                    request.getPhone(),
                    request.getEmail());
            default -> throw new IllegalStateException("Unexpected value: " + request.getType());
        };
        UserEntity registerPetOwner = userDAO.registerUser(petOwner);
        responseObserver.onNext(UserMapper.mapProto(registerPetOwner));
        responseObserver.onCompleted();
    }

    @Override
    public void findUser(SearchFieldProto request, StreamObserver<UserProto> responseObserver)
    {
        UserEntity petOwner = userDAO.findUser(request.getQuery());
        if (petOwner != null)
        {
            responseObserver.onNext(UserMapper.mapProto(petOwner));
            responseObserver.onCompleted();
        }
        else
        {
            responseObserver.onError(new Exception("Error: There is no Pet Owner with such an email"));
        }
    }


}
