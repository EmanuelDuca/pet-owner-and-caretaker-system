package dk.via.sep3.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import dk.via.sep3.DAOInterfaces.AnnouncementDAOInterface;
import dk.via.sep3.DAOInterfaces.CareRequestServiceDaoInterface;
import dk.via.sep3.DAOInterfaces.UserDAOInterface;
import dk.via.sep3.shared.AnnouncementEntity;
import dk.via.sep3.shared.CareServiceRequestEntity;
import dk.via.sep3.shared.UserEntity;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import origin.protobuf.CareServiceRequestGrpc;
import origin.protobuf.ResponseStatus;
import origin.protobuf.StartCareServiceRequest;

import java.io.IOException;

@GRpcService
public class CareRequestService extends CareServiceRequestGrpc.CareServiceRequestImplBase
{
    private static WebSocketSession session;
    private final UserDAOInterface userDao;
    private final AnnouncementDAOInterface announcementDAO;
    private final CareRequestServiceDaoInterface careServiceRequestDAO;

    @Autowired
    public CareRequestService(UserDAOInterface userDao, AnnouncementDAOInterface announcementDAO, CareRequestServiceDaoInterface careServiceRequestDAO)
    {
        this.userDao = userDao;
        this.announcementDAO = announcementDAO;
        this.careServiceRequestDAO = careServiceRequestDAO;
    }

    @Override
    public void offerCare(StartCareServiceRequest request, StreamObserver<ResponseStatus> responseObserver)
    {
        try
        {
            UserEntity initiator = userDao.findUser(request.getInitiatorEmail());
            UserEntity recipient = userDao.findUser(request.getRecipientEmail());
            AnnouncementEntity announcement = announcementDAO.getAnnouncement(request.getAnnouncementId());
            careServiceRequestDAO.createAnnouncement(new CareServiceRequestEntity(initiator, recipient, announcement));
            session.sendMessage(new TextMessage(new ObjectMapper().writeValueAsString(request)));// todo finish
            // todo deserialize in c# + make simple page to test everything
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static class ServiceRequestWebSocketHandler extends TextWebSocketHandler
    {
        @Override
        public void afterConnectionEstablished(WebSocketSession session) throws Exception {
            System.out.println("WebSocket opened: " + session.getId());
            CareRequestService.session = session;
        }

        @Override
        protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
            System.out.println("Received from client " + session.getId() + ": " + message.getPayload());
            session.sendMessage(new TextMessage("Message received: " + message.getPayload()));
        }

        @Override
        public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
            System.out.println("WebSocket closed: " + session.getId());
        }

        public static WebSocketSession getSession()
        {
            return session;
        }
    }
}
