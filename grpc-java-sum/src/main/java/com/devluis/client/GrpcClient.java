package com.devluis.client;

import com.proto.sum.SumRequest;
import com.proto.sum.SumResponse;
import com.proto.sum.SumServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.logging.Logger;

import static com.devluis.utils.ApplicationConstant.PORT_SERVER_GRPC;

public class GrpcClient {
    private static final Logger log = Logger.getLogger(GrpcClient.class.getName());

    public static void main(String[] args) {

        int value1 = 13, value2 = 30;

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("127.0.0.1", PORT_SERVER_GRPC)
                .usePlaintext()
                .build();


        SumServiceGrpc.SumServiceBlockingStub stub = SumServiceGrpc.newBlockingStub(channel);

        SumRequest request = SumRequest.newBuilder()
                .setValue1(value1)
                .setValue2(value2)
                .build();

        SumResponse response = stub.execute(request);

        log.info("Total : " + response.getResult());

        log.info("Shutting down");
        channel.shutdown();
    }
}
