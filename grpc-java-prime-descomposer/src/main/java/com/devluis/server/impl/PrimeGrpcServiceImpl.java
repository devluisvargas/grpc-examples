package com.devluis.server.impl;

import com.prime.grpc.PrimeRequest;
import com.prime.grpc.PrimeResponse;
import com.prime.grpc.PrimeServiceGrpc.PrimeServiceImplBase;
import io.grpc.stub.StreamObserver;

import java.util.logging.Logger;

public class PrimeGrpcServiceImpl extends PrimeServiceImplBase {

    private static final Logger log = Logger.getLogger(PrimeGrpcServiceImpl.class.getName());

    @Override
    public void execute(PrimeRequest request, StreamObserver<PrimeResponse> responseObserver) {
        log.info("Inicio de prime number: " + request.getValue());

        int divisor = 2;
        int number = request.getValue();

        while (number > 1) {
            if (number % divisor == 0) {
                number = number / divisor;
                responseObserver.onNext(PrimeResponse.newBuilder().setResult(divisor).build());
            } else {
                divisor = divisor + 1;
            }
        }


        responseObserver.onCompleted();
    }
}
