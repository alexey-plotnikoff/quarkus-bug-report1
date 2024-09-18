package am.plotnikov.bugreport1.service;

import am.plotnikov.bugreport1.grpc.GreeterGrpc;
import am.plotnikov.bugreport1.grpc.HelloRequest;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import io.quarkus.grpc.GrpcService;
import io.smallrye.common.annotation.RunOnVirtualThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class HelloWorldService extends GreeterGrpc.GreeterImplBase {

    private static final Logger log = LoggerFactory.getLogger(HelloWorldService.class);

    private final KafkaService kafkaService;

    public HelloWorldService(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @Override
    @RunOnVirtualThread
    public void sayHello(HelloRequest request, StreamObserver<Empty> responseObserver) {
        log.info("gRPC started");
        kafkaService.runAction("hello");
        log.info("gRPC finished");
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }
}
