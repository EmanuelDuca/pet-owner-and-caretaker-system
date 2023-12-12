package dk.via.sep3.services;

import dk.via.sep3.DAOInterfaces.AnnouncementDAOInterface;
import dk.via.sep3.DAOInterfaces.PetServiceDAOInterface;
import dk.via.sep3.DAOInterfaces.PetServiceRequestDAOInterface;
import dk.via.sep3.DAOInterfaces.UserDAOInterface;
import dk.via.sep3.mappers.FeedbackMapper;
import dk.via.sep3.mappers.ServiceMapper;
import dk.via.sep3.mappers.RequestMapper;
import dk.via.sep3.model.*;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import origin.protobuf.*;
import origin.protobuf.FindAnnouncementProto;
import origin.protobuf.FindRequestServiceProto;
import origin.protobuf.FindServiceProto;
import origin.protobuf.RequestServicesProto;
import origin.protobuf.SearchServiceProto;
import origin.protobuf.ServiceProto;
import origin.protobuf.ServiceRequestProto;
import origin.protobuf.ServicesProto;
import origin.protobuf.Void;

import javax.transaction.Transactional;
import java.util.Collection;

@GRpcService
public class ServiceService extends ServiceServiceGrpc.ServiceServiceImplBase
{
    private final UserDAOInterface userDao;
    private final AnnouncementDAOInterface announcementDAO;
    private final PetServiceRequestDAOInterface careServiceRequestDAO;
    private final PetServiceDAOInterface careServiceDAO;

    @Autowired
    public ServiceService(UserDAOInterface userDao, AnnouncementDAOInterface announcementDAO, PetServiceRequestDAOInterface careServiceRequestDAO, PetServiceDAOInterface careServiceDAO)
    {
        this.userDao = userDao;
        this.announcementDAO = announcementDAO;
        this.careServiceRequestDAO = careServiceRequestDAO;
        this.careServiceDAO = careServiceDAO;
    }

    @Override
    @Transactional
    public void requestStartService(ServiceRequestProto request, StreamObserver<Void> responseObserver)
    {
        UserEntity initiator = userDao.findUser(request.getInitiatorEmail());
        UserEntity recipient = userDao.findUser(request.getRecipientEmail());
        AnnouncementEntity announcement = announcementDAO.getAnnouncement(request.getAnnouncementId());
        var serviceRequest = careServiceRequestDAO.createServiceRequest(new RequestEntity(initiator,recipient,announcement));

        if(serviceRequest == null)
        {
            responseObserver.onError(GrpcErrorService.constructException("Can't offer care service"));
            return;
        }

        responseObserver.onNext(Void.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    @Transactional
    public void acceptStartService(FindRequestServiceProto request, StreamObserver<Void> responseObserver)
    {
        RequestEntity serviceRequest = careServiceRequestDAO.getServiceRequestById(request.getRequestId());
        UserEntity initiator = userDao.findUser(serviceRequest.getInitiator().getEmail());
        UserEntity recipient = userDao.findUser(serviceRequest.getRecipient().getEmail());

        UserEntity careTaker;
        UserEntity petOwner;


        if(initiator.getUserType().equals("CareTaker"))
        {
            careTaker = initiator;
            petOwner = recipient;
        }
        else
        {
            careTaker = recipient;
            petOwner = initiator;
        }

        if(careServiceDAO.exists(serviceRequest.getAnnouncement(), careTaker, recipient))
        {
            responseObserver.onError(GrpcErrorService.constructException("Service already exists"));
            return;
        }

        if(!careServiceRequestDAO.confirmServiceRequest(request.getRequestId()))
        {
            responseObserver.onError(GrpcErrorService.constructException("Service request with id: " + request.getRequestId() + " doesn't exist"));
            return;
        }


        ServiceEntity service = careServiceDAO.createService(new ServiceEntity(
                careTaker,
                petOwner,
                serviceRequest.getAnnouncement()
        ));

        FinishServiceScheduler serviceToFinishService = new FinishServiceScheduler(careServiceDAO);
        serviceToFinishService.scheduleServiceEnd(service);

        responseObserver.onNext(Void.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    @Transactional
    public void denyStartService(FindRequestServiceProto request, StreamObserver<Void> responseObserver)
    {
        if(!careServiceRequestDAO.denyServiceRequest(request.getRequestId()))
        {
            responseObserver.onError(GrpcErrorService.constructException("Service request with id: " + request.getRequestId() + " doesn't exist"));
            return;
        }

        responseObserver.onNext(Void.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    @Transactional
    public void endService(FindServiceProto request, StreamObserver<Void> responseObserver)
    {
        careServiceDAO.endService(request.getServiceId());
        responseObserver.onNext(Void.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    @Transactional
    public void searchRequestServices(FindAnnouncementProto request, StreamObserver<RequestServicesProto> responseObserver)
    {
        Collection<RequestEntity> requests = careServiceRequestDAO.searchServiceRequests(request.getId());

        if (requests.isEmpty())
        {
            responseObserver.onError(GrpcErrorService.constructException("No such requests"));
            return;
        }

        Collection<ServiceRequestProto> requestsCollection = requests
                .stream().map(RequestMapper::mapToProto).toList();


        RequestServicesProto requestsProtoItems = RequestServicesProto.newBuilder().addAllRequestServices(requestsCollection).build();

        requestsProtoItems.getRequestServicesList().forEach(r -> System.out.println("Id: " + r.getId()));
        responseObserver.onNext(requestsProtoItems);
        responseObserver.onCompleted();
    }

    @Override
    @Transactional
    public void searchServices(SearchServiceProto request, StreamObserver<ServicesProto> responseObserver)
    {
        Collection<ServiceEntity> services = careServiceDAO.searchServices(
                request.hasCaretakerEmail()? request.getCaretakerEmail().getValue() : null,
                request.hasPetOwnerEmail()? request.getPetOwnerEmail().getValue() : null,
                request.getStatus()
        );

        if (services.isEmpty())
        {
            responseObserver.onError(GrpcErrorService.constructException("No such services"));
            return;
        }

        Collection<ServiceProto> servicessCollection = services
                .stream().map(ServiceMapper::mapToProto).toList();

        ServicesProto servicesProtoItems = ServicesProto.newBuilder().addAllServices(servicessCollection).build();
        responseObserver.onNext(servicesProtoItems);
        responseObserver.onCompleted();
    }

    @Override
    @Transactional
    public void findService(FindServiceProto request, StreamObserver<ServiceProto> responseObserver)
    {
        responseObserver.onNext(ServiceMapper.mapToProto(careServiceDAO.findServiceById(request.getServiceId())));
        responseObserver.onCompleted();
    }

    @Override
    public void addFeedback(FeedbackProto request, StreamObserver<Void> responseObserver)
    {

        try
        {
            careServiceDAO.giveFeedback(new FeedbackEntity(
                    careServiceDAO.findServiceById(request.getServiceId()),
                    request.getRating(),
                    request.getFeedback()));
        }
        catch (Exception e)
        {
            responseObserver.onError(GrpcErrorService.constructException(e.getMessage()));
            return;
        }

        responseObserver.onNext(Void.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void deleteFeedback(FindFeedbackProto request, StreamObserver<Void> responseObserver)
    {
        careServiceDAO.deleteFeedback(request.getServiceId());

        responseObserver.onNext(Void.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void searchFeedbacks(FindUserProto request, StreamObserver<FeedbacksProto> responseObserver)
    {
        var feedbacks = careServiceDAO.getFeedbacks(userDao.findUser(request.getEmail()))
                .stream()
                .map(FeedbackMapper::mapToProto).toList();

        responseObserver.onNext(
                FeedbacksProto.newBuilder()
                        .addAllFeedback(feedbacks)
                        .build());
        responseObserver.onCompleted();
    }
}
