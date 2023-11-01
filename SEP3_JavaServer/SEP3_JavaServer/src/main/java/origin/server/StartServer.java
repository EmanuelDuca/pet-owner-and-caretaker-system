package origin.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import origin.services.AnnouncementService;
import origin.services.PetOwnerService;


public class StartServer {
    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder
                .forPort(9090)
                .addService(new AnnouncementService())
                .addService(new PetOwnerService())
                .build();
        server.start();
        System.out.println("Server is running on port:" + server.getPort());
        server.awaitTermination();
    }


}
