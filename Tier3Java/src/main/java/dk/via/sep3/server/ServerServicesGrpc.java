package dk.via.sep3.server;

import dk.via.sep3.services.UserService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

public  class ServerServicesGrpc {
    public static void configServicesGrpc() throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(9091)
                .addService(new UserService())
                .build();
        server.start();
        System.out.println("Server is running on port:" + server.getPort());
       server.awaitTermination();
    }
}
