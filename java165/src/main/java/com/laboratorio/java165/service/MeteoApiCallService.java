package com.laboratorio.java165.service;

import com.google.gson.Gson;
import com.laboratorio.java165.dto.CurrentForecastDTO;
import com.laboratorio.java165.dto.HourlyForecastDTO;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

public class MeteoApiCallService {
    private static final String URL_BASE = "https://api.open-meteo.com/v1";
    private static final String FORECAST_ENDPOINT = "/forecast";
    private static final String LATITUDE = "latitude";
    private static final String LONGITUDE = "longitude";
    private static final String TEMPERATURE_2M = "temperature_2m";
    
    private final Client client;
    private final Gson gson;

    public MeteoApiCallService() {
        this.client = ClientBuilder.newClient();
        this.gson = new Gson();
    }
    
    private String getApiResponse(String apiTarget, double lat, double lon, String operation) {
        WebTarget target = this.client.target(apiTarget)
                .queryParam(LATITUDE, lat)
                .queryParam(LONGITUDE, lon)
                .queryParam(operation, TEMPERATURE_2M);
        
        return target.request()
                .accept(MediaType.APPLICATION_JSON)
                .get(String.class);
    }
    
    public CurrentForecastDTO currentForecast(double lat, double lon) {
        String targetStr = URL_BASE + FORECAST_ENDPOINT;
        String responseStr = this.getApiResponse(targetStr, lat, lon, "current");
        return this.gson.fromJson(responseStr, CurrentForecastDTO.class);
    }
    
    public HourlyForecastDTO hourlyForecast(double lat, double lon) {
        String targetStr = URL_BASE + FORECAST_ENDPOINT;
        String responseStr = this.getApiResponse(targetStr, lat, lon, "hourly");
        return this.gson.fromJson(responseStr, HourlyForecastDTO.class);
    }
}