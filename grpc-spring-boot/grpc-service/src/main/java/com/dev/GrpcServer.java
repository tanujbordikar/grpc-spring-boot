package com.dev;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.dev.BookAuthorServiceGrpc.BookAuthorServiceImplBase;
import com.dev.entity.UserGrpcService;
import com.dev.entity.UserService;

import jakarta.annotation.PostConstruct;

@Component
public class GrpcServer {

    @Value("${grpc.server.port:12000}")  // default to 12000
    private int grpcPort;
    
    @Autowired
    private UserService userService;

    private Server server;

    @PostConstruct
    public void startServer() throws Exception {
        server = ServerBuilder
                .forPort(grpcPort)
                .addService(new BookAuthorServerService()) // your gRPC implementation
                .addService(new UserGrpcService(userService)) // your gRPC implementation
                .build()
                .start();

        System.out.println("✅ gRPC Server started on port " + grpcPort);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down gRPC server...");
            if (server != null) {
                server.shutdown();
            }
        }));
    }
}

