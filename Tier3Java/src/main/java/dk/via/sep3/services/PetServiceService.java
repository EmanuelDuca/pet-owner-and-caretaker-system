package dk.via.sep3.services;

import dk.via.sep3.DAOInterfaces.AnnouncementDAOInterface;
import dk.via.sep3.DAOInterfaces.PetServiceRequestInterface;
import dk.via.sep3.DAOInterfaces.UserDAOInterface;
import dk.via.sep3.shared.AnnouncementEntity;
import dk.via.sep3.shared.CareServiceRequestEntity;
import dk.via.sep3.shared.UserEntity;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import origin.protobuf.ServiceRequest;
import origin.protobuf.ServiceServiceGrpc;
import origin.protobuf.Void;

import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

@GRpcService
public class PetServiceService extends ServiceServiceGrpc.ServiceServiceImplBase
{
    private final UserDAOInterface userDao;
    private final AnnouncementDAOInterface announcementDAO;
    private final PetServiceRequestInterface careServiceRequestDAO;

    @Autowired
    public PetServiceService(UserDAOInterface userDao, AnnouncementDAOInterface announcementDAO, PetServiceRequestInterface careServiceRequestDAO)
    {
        this.userDao = userDao;
        this.announcementDAO = announcementDAO;
        this.careServiceRequestDAO = careServiceRequestDAO;
    }

    @Override
    public void requestStartService(ServiceRequest request, StreamObserver<Void> responseObserver)
    {
        UserEntity initiator = userDao.findUser(request.getInitiatorEmail());
        UserEntity recipient = userDao.findUser(request.getRecipientEmail());
        AnnouncementEntity announcement = announcementDAO.getAnnouncement(request.getAnnouncementId());
        var serviceRequest = careServiceRequestDAO.createServiceRequestOffer(new CareServiceRequestEntity(initiator, recipient, announcement));

        if(serviceRequest == null)
            responseObserver.onError(GrpcError.constructException("Can't offer care service"));
    }

//    public void acceptStartService(origin.protobuf.ServiceRequest request,
//                                   io.grpc.stub.StreamObserver<origin.protobuf.Void> responseObserver)
//    {
//        asyncUnimplementedUnaryCall(METHOD_ACCEPT_START_SERVICE, responseObserver);
//    }
//
//    /**
//     */
//    public void denyStartService(origin.protobuf.ServiceRequest request,
//                                 io.grpc.stub.StreamObserver<origin.protobuf.Void> responseObserver)
//    {
//        asyncUnimplementedUnaryCall(METHOD_DENY_START_SERVICE, responseObserver);
//    }
//
//    /**
//     */
//    public void endService(origin.protobuf.FindServiceProto request,
//                           io.grpc.stub.StreamObserver<origin.protobuf.Void> responseObserver)
//    {
//        asyncUnimplementedUnaryCall(METHOD_END_SERVICE, responseObserver);
//    }
//
//    /**
//     */
//    public void findRequestServices(origin.protobuf.SearchAnnouncementProto request,
//                                    io.grpc.stub.StreamObserver<origin.protobuf.RequestServicesProto> responseObserver)
//    {
//        asyncUnimplementedUnaryCall(METHOD_FIND_REQUEST_SERVICES, responseObserver);
//    }
//
//    /**
//     */
//    public void findServices(origin.protobuf.SearchServiceProto request,
//                             io.grpc.stub.StreamObserver<origin.protobuf.ServicesProto> responseObserver)
//    {
//        asyncUnimplementedUnaryCall(METHOD_FIND_SERVICES, responseObserver);
//    }
//
//    /**
//     */
//    public void getService(origin.protobuf.FindServiceProto request,
//                           io.grpc.stub.StreamObserver<origin.protobuf.ServiceProto> responseObserver)
//    ={
//        asyncUnimplementedUnaryCall(METHOD_GET_SERVICE, responseObserver);
//    }


}
