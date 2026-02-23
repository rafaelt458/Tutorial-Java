package com.laboratorio.java165.service;

import com.laboratorio.grpc.MeteoRequest;
import com.laboratorio.grpc.MeteoServiceGrpc;
import com.laboratorio.grpc.TemperatureListResponse;
import com.laboratorio.grpc.TemperatureResponse;
import com.laboratorio.java165.dto.CurrentForecastDTO;
import com.laboratorio.java165.dto.HourlyForecastDTO;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MeteoServiceImpl extends MeteoServiceGrpc.MeteoServiceImplBase {
    private static final Logger log = LoggerFactory.getLogger(MeteoServiceImpl.class);
    private final MeteoApiCallService meteoApiCallService;

    public MeteoServiceImpl() {
        this.meteoApiCallService = new MeteoApiCallService();
    }
    
    @Override
    public void currentTemperature(MeteoRequest request,
            StreamObserver<TemperatureResponse> responseObserver) {
        
        log.info("Se ha recibido una solicitud de temperatura actual: {}", request.toString());
        
        CurrentForecastDTO forecast = this.meteoApiCallService.currentForecast(request.getLatitude(),
                request.getLongitude());
        TemperatureResponse response = TemperatureResponse.newBuilder()
                .setTime(forecast.current().time())
                .setTemperature(forecast.current().temperature2m())
                .build();
        
        log.info("La temperatura actual ha sido obtenida: {}", response.toString());
        
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void hourlyTemperature(MeteoRequest request,
            StreamObserver<TemperatureListResponse> responseObserver) {
        
        log.info("Se ha recibido una solicitud de temperatura por hora: {}", request.toString());
        
        HourlyForecastDTO forecast = this.meteoApiCallService.hourlyForecast(request.getLatitude(),
                request.getLongitude());
        
        List<TemperatureResponse> temperatures = new ArrayList<>();
        for (int i = 0; i < forecast.hourly().time().size(); i++) {
            TemperatureResponse temperatureResponse = TemperatureResponse.newBuilder()
                    .setTime(forecast.hourly().time().get(i))
                    .setTemperature(forecast.hourly().temperature2m().get(i))
                    .build();
            temperatures.add(temperatureResponse);
        }
        
        TemperatureListResponse response = TemperatureListResponse.newBuilder()
                .addAllTemperatures(temperatures)
                .build();
        
        log.info("La temperatura por hora ha sido obtenida: {}", response.toString());
        
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}