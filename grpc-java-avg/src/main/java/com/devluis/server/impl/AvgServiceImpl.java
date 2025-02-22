package com.devluis.server.impl;

import com.avg.proto.AvgRequest;
import com.avg.proto.AvgResponse;
import com.avg.proto.AvgServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class AvgServiceImpl extends AvgServiceGrpc.AvgServiceImplBase {

    private static final Logger log = Logger.getLogger(AvgServiceImpl.class.getName());

    @Override
    public StreamObserver<AvgRequest> execute(StreamObserver<AvgResponse> responseObserver) {
        List<Integer> items = new ArrayList<>();
        return new StreamObserver<>() {
            @Override
            public void onNext(AvgRequest avgRequest) {
                log.info("Value "+ avgRequest.getValue());
                items.add(avgRequest.getValue());
            }

            @Override
            public void onError(Throwable throwable) {
                responseObserver.onError(throwable);
            }

            @Override
            public void onCompleted() {
                Optional<Integer> total = items.stream().reduce(Integer::sum);
                double result = 0.0;
                if(total.isPresent()) {
                     result = (double) total.get() / items.size();
                }
                log.info("Avg "+ result);
                responseObserver.onNext(com.avg.proto.AvgResponse.newBuilder().setResult(result).build());
                responseObserver.onCompleted();
            }
        };
    }
}
