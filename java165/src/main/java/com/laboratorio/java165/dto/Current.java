package com.laboratorio.java165.dto;

import com.google.gson.annotations.SerializedName;

public record Current(
        String time,
        String interval,
        @SerializedName("temperature_2m")
        double temperature2m
        ) {
}