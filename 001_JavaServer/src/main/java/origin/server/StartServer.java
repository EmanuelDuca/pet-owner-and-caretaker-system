package origin.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import origin.services.AnnouncementService;
import origin.services.UserService;
import origin.shared.TimeIntervalEntity;


public class StartServer {
    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder
                .forPort(9090)
                .addService(new AnnouncementService())
                .addService(new UserService())
                .build();
        server.start();
        System.out.println("Server is running on port:" + server.getPort());
        TimeIntervalEntity tm = new TimeIntervalEntity("dfvrf", "rggrvr");
        System.out.println(tm.toString());
        server.awaitTermination();
        System.out.print("TEst");
    }


}
