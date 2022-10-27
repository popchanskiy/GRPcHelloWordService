import com.example.grpc.*;
import io.grpc.stub.*;

public class ServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {
    @Override
    public void doHello(ServiceApi.RequestExample request, StreamObserver<ServiceApi.ResponseExample> responseObserver) {
        System.out.println(request);
        ServiceApi.ResponseExample response = ServiceApi.ResponseExample.newBuilder()
                .setHelloMessage(String.format("Hello, %s",request.getName()))
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
