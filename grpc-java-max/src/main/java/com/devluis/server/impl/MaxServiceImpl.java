package com.devluis.server.impl;

import com.max.proto.MaxRequest;
import com.max.proto.MaxResponse;
import com.max.proto.MaxServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class MaxServiceImpl extends MaxServiceGrpc.MaxServiceImplBase {

    @Override
    public StreamObserver<MaxRequest> execute(StreamObserver<MaxResponse> responseObserver) {
        return new StreamObserver<>() {
            int max = 0;

            @Override
            public void onNext(MaxRequest maxRequest) {
                if(maxRequest.getValue() > max){
                    max = maxRequest.getValue();
                    responseObserver.onNext(com.max.proto.MaxResponse.newBuilder().setResult(max).build());
                }
            }

            @Override
            public void onError(Throwable throwable) {
                responseObserver.onError(throwable);
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}
