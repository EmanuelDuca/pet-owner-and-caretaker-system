package dk.via.sep3.services;

import dk.via.sep3.DAOInterfaces.AnnouncementDAOInterface;
import dk.via.sep3.DAOInterfaces.PetServiceDAOInterface;
import dk.via.sep3.DAOInterfaces.PetServiceRequestDAOInterface;
import dk.via.sep3.DAOInterfaces.UserDAOInterface;
import dk.via.sep3.shared.AnnouncementEntity;
import dk.via.sep3.shared.PetServiceEntity;
import dk.via.sep3.shared.PetServiceRequestEntity;
import dk.via.sep3.shared.UserEntity;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import origin.protobuf.*;
import origin.protobuf.Void;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

@GRpcService
public class PetServiceService extends ServiceServiceGrpc.ServiceServiceImplBase
{
    private final UserDAOInterface userDao;
    private final AnnouncementDAOInterface announcementDAO;
    private final PetServiceRequestDAOInterface careServiceRequestDAO;
    private final PetServiceDAOInterface careServiceDAO;

    @Autowired
    public PetServiceService(UserDAOInterface userDao, AnnouncementDAOInterface announcementDAO, PetServiceRequestDAOInterface careServiceRequestDAO, PetServiceDAOInterface careServiceDAO)
    {
        this.userDao = userDao;
        this.announcementDAO = announcementDAO;
        this.careServiceRequestDAO = careServiceRequestDAO;
        this.careServiceDAO = careServiceDAO;
    }

    @Override
    public void requestStartService(ServiceRequest request, StreamObserver<Void> responseObserver)
    {
        UserEntity initiator = userDao.findUser(request.getInitiatorEmail());
        UserEntity recipient = userDao.findUser(request.getRecipientEmail());
        AnnouncementEntity announcement = announcementDAO.getAnnouncement(request.getAnnouncementId());
        var serviceRequest = careServiceRequestDAO.createServiceRequest(new PetServiceRequestEntity(initiator,recipient,announcement));

        if(serviceRequest == null)
            responseObserver.onError(GrpcError.constructException("Can't offer care service"));
    }

    @Override
    public void acceptStartService(FindRequestServiceProto request, StreamObserver<Void> responseObserver)
    {
//        careServiceRequestDAO.confirmServiceRequest(request.getRequestId());
//        careServiceDAO.createService(new PetServiceEntity(
//                careServiceRequestDAO.
//        ));
    }

    @Override
    public void denyStartService(FindRequestServiceProto request, StreamObserver<Void> responseObserver)
    {
        careServiceRequestDAO.denyServiceRequest(request.getRequestId());
    }

    @Override
    public void endService(FindRequestServiceProto request, StreamObserver<Void> responseObserver)
    {
        super.endService(request, responseObserver);
    }

    @Override
    public void searchRequestServices(SearchAnnouncementProto request, StreamObserver<RequestServicesProto> responseObserver)
    {
        super.searchRequestServices(request, responseObserver);
    }

    @Override
    public void searchServices(SearchServiceProto request, StreamObserver<ServicesProto> responseObserver)
    {
        super.searchServices(request, responseObserver);
    }

    @Override
    public void findService(FindServiceProto request, StreamObserver<ServiceProto> responseObserver)
    {
        super.findService(request, responseObserver);
    }
}
