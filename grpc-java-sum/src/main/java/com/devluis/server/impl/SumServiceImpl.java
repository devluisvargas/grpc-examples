package com.devluis.server.impl;

import com.proto.sum.SumRequest;
import com.proto.sum.SumResponse;
import com.proto.sum.SumServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.logging.Logger;

public class SumServiceImpl extends SumServiceGrpc.SumServiceImplBase {
    private static final Logger log = Logger.getLogger(SumServiceImpl.class.getName());

    @Override
    public void execute(SumRequest request, StreamObserver<SumResponse> responseObserver) {
        log.info("Inicio de operacion valor 1: " + request.getValue1() + " valor 2: " + request.getValue2());
        int result = request.getValue1() + request.getValue2();
        SumResponse response = SumResponse.newBuilder().setResult(result).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
