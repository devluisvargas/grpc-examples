package com.devluis.client;

import com.prime.grpc.PrimeRequest;
import com.prime.grpc.PrimeResponse;
import com.prime.grpc.PrimeServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Iterator;
import java.util.logging.Logger;

import static com.devluis.utils.ApplicationConstant.PORT_SERVER_GRPC;

public class GrpcClient {

    private static final Logger log = Logger.getLogger(GrpcClient.class.getName());

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", PORT_SERVER_GRPC)
                .usePlaintext()
                .build();
        PrimeServiceGrpc.PrimeServiceBlockingStub stub = PrimeServiceGrpc.newBlockingStub(channel);
        PrimeRequest request = PrimeRequest.newBuilder()
                .setValue(125)
                .build();

        stub.execute(request).forEachRemaining(e-> log.info(String.valueOf(e.getResult())));

        log.info("Shutting down");
        channel.shutdown();
    }
}
