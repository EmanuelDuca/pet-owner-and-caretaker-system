package dk.via.sep3.services;

import io.grpc.stub.StreamObserver;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.web.server.WebSession;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import origin.protobuf.CommunicationServiceGrpc;
import origin.protobuf.ResponseStatus;
import origin.protobuf.UserProto;

import java.io.IOException;

public class CommunicationService extends CommunicationServiceGrpc.CommunicationServiceImplBase
{
    private static WebSocketSession session;

    @Override
    public void offerCare(UserProto request, StreamObserver<ResponseStatus> responseObserver)
    {
        try
        {
            session.sendMessage(new TextMessage("okay lets go"));
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
            CommunicationService.session = session;
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
