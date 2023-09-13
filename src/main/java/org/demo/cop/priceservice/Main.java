package org.demo.cop.priceservice;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String portStr = System.getenv("server.port");
        if (portStr == null || portStr.isEmpty()) {
            portStr = "8999";
        }

        int port = Integer.parseInt(portStr);

        Server server = ServerBuilder.forPort(port).addService(new PriceServiceImpl()).build();
        server.start();
        System.out.println("Server Started on port: " + port);
        server.awaitTermination();
    }
}