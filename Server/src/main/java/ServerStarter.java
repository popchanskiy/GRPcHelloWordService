import io.grpc.*;

import java.io.*;

public class ServerStarter {
    public static void init()  {
        Server server = ServerBuilder.forPort(8080)
                .addService(new ServiceImpl())
                .build();
        try {
            server.start();
            System.out.println("Server started");
            server.awaitTermination();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            server.shutdown();
        }
    }
}
