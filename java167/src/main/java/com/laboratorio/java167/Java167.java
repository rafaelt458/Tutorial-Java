package com.laboratorio.java167;

import com.laboratorio.grpc.MeteoRequest;
import com.laboratorio.grpc.MeteoServiceGrpc;
import com.laboratorio.grpc.TemperatureListResponse;
import com.laboratorio.grpc.TemperatureResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Java167 {
    private static final Logger log = LoggerFactory.getLogger(Java167.class);
    private static final int PORT = 8082;
   
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", PORT)
                .usePlaintext()
                .build();
        
        log.info("Cliente gRPC iniciado en el puerto: {}", PORT);
        
        MeteoServiceGrpc.MeteoServiceBlockingStub stub = MeteoServiceGrpc.newBlockingStub(channel);
        
        MeteoRequest request = MeteoRequest.newBuilder()
                .setLatitude(52.5)
                .setLongitude(13.5)
                .build();
        
        log.info("Voy a efectuar la siguiente solicitud de temperatura actual: {}", request);
        
        TemperatureResponse response = stub.currentTemperature(request);
        
        log.info("Respuesta recibida para la solicitud de temperatura actual: {}", response);
        
        log.info("Voy a efectuar la siguiente solicitud de temperatura por hora: {}", request);
        
        TemperatureListResponse listResponse = stub.hourlyTemperature(request);
        
        log.info("Respuesta recibida para la solicitud de temperatura por hora: {}", listResponse);
    }
}