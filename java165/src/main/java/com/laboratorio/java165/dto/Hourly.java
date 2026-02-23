package com.laboratorio.java165.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public record Hourly(
        List<String> time,
        @SerializedName("temperature_2m")
        List<Double> temperature2m
        ) {
}