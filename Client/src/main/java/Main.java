import com.example.grpc.*;
import io.grpc.*;

import java.util.concurrent.*;

public class Main {
    static ManagedChannel channel;
    static HelloServiceGrpc.HelloServiceBlockingStub stub;
    static ServiceApi.RequestExample request;
    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            channel= ManagedChannelBuilder.forTarget("localhost:8080").usePlaintext().build();
            stub = HelloServiceGrpc.newBlockingStub(channel);
            request= ServiceApi.RequestExample.newBuilder()
                    .setName("Pupa")
                    .build();
            ClientImpl.sendRequest(channel,stub,request);
            channel.shutdown();
        }
    }
}
