package origin.services;

import io.grpc.stub.StreamObserver;
import origin.DAO.PetOwnerDAO;
import origin.DAOInterfaces.PetOwnerDAOInterface;
import origin.mappers.PetOwnerMapper;
import origin.protobufClasses.LoginUser;
import origin.protobufClasses.PetOwner;
import origin.protobufClasses.PetOwnerServiceGrpc;
import origin.protobufClasses.SearchField;
import origin.shared.PetOwnerEntity;



public class PetOwnerService extends PetOwnerServiceGrpc.PetOwnerServiceImplBase {

    private final PetOwnerDAOInterface petOwnerDAO;
    public PetOwnerService()
    {
        petOwnerDAO = new PetOwnerDAO();
    }

    @Override
    public void loginPetOwner(LoginUser request, StreamObserver<PetOwner> responseObserver)
    {
        PetOwnerEntity petOwner = new PetOwnerEntity(request.getEmail(), request.getPassword());
        PetOwnerEntity loginUser = petOwnerDAO.loginPetOwner(petOwner);
        responseObserver.onNext(PetOwnerMapper.mapProto(loginUser));
        responseObserver.onCompleted();
    }

    @Override
    public void createPetOwner(PetOwner request, StreamObserver<PetOwner> responseObserver)
    {
        PetOwnerEntity petOwner = new PetOwnerEntity(
                request.getUsername(),
                request.getPassword(),
                request.getAge(),
                request.getPhone(),
                request.getEmail());
        PetOwnerEntity registerPetOwner = petOwnerDAO.registerUser(petOwner);
        responseObserver.onNext(PetOwnerMapper.mapProto(registerPetOwner));
        responseObserver.onCompleted();

        System.out.println("Create new User"+petOwner.getEmail()+" "+petOwner.getUsername());
    }

    @Override
    public void findPetOwner(SearchField request, StreamObserver<PetOwner> responseObserver)
    {
        PetOwnerEntity petOwner = petOwnerDAO.findPetOwner(request.getSearch());
        if (petOwner != null)
        {
            responseObserver.onNext(PetOwnerMapper.mapProto(petOwner));
            responseObserver.onCompleted();
        }
        else
        {
            responseObserver.onError(new Exception("Error: There is no Pet Owner with such an email"));
        }
    }


}
