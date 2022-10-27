import com.example.grpc.*;
import io.grpc.*;
import io.grpc.stub.*;

public class ClientImpl {
    static ServiceApi.ResponseExample response;

    public static void sendRequest(Channel channel, HelloServiceGrpc.HelloServiceBlockingStub stub,ServiceApi.RequestExample request) {
        response = stub.doHello(request);
        System.out.println(response);
    }
}
