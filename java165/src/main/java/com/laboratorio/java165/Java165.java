package com.laboratorio.java165;

import com.laboratorio.java165.service.MeteoServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Java165 {
    private static final Logger log = LoggerFactory.getLogger(Java165.class);
    private static final int PORT = 8082;
    
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(PORT)
                .addService(new MeteoServiceImpl())
                .build();
        
        server.start();
        log.info("Servidor iniciado y escuchando el puerto: {}", PORT);
        server.awaitTermination();
    }
}
