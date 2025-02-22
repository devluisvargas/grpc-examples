package com.devluis.client;

import com.max.proto.MaxResponse;
import com.max.proto.MaxServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static com.devluis.utils.ApplicationConstant.PORT_SERVER_GRPC;

public class GrpcClient {
    private static final Logger log = Logger.getLogger(GrpcClient.class.getName());

    public static void main(String[] args) throws InterruptedException {

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("127.0.0.1", PORT_SERVER_GRPC)
                .usePlaintext()
                .build();

        MaxServiceGrpc.MaxServiceStub stub = MaxServiceGrpc.newStub(channel);

        List<Integer> items = List.of(1,5,3,6,2,20);
        CountDownLatch latch = new CountDownLatch(1);


         var streams = stub.execute(new StreamObserver<>() {
             @Override
             public void onNext(MaxResponse maxResponse) {
                 log.info("Result: "+ maxResponse.getResult());
             }

             @Override
             public void onError(Throwable throwable) {
                log.warning(throwable.getMessage());
             }

             @Override
             public void onCompleted() {
                 latch.countDown();
             }
         });

        items.forEach(e-> streams.onNext(com.max.proto.MaxRequest.newBuilder().setValue(e).build()));
        streams.onCompleted();
        latch.await(3, TimeUnit.SECONDS);


        log.info("Shutting down");
        channel.shutdown();
    }
}
