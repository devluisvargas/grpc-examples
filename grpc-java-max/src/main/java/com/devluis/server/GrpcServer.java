package com.devluis.server;

//import com.devluis.server.impl.MaxServiceImpl;
import com.devluis.server.impl.MaxServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.logging.Logger;

import static com.devluis.utils.ApplicationConstant.PORT_SERVER_GRPC;

public class GrpcServer {

    private static final Logger log = Logger.getLogger(GrpcServer.class.getName());


    public static void main(String[] args) throws InterruptedException, IOException {
        Server server = ServerBuilder
                .forPort(PORT_SERVER_GRPC)
                .addService(new MaxServiceImpl())
                .build();

        server.start();

        log.info("Server Started");
        log.info("Listening in port: " + PORT_SERVER_GRPC);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            log.info("Receiver Shutdown request");
            server.shutdown();
            log.info("Server stopped");
        }));
        server.awaitTermination();
    }
}
