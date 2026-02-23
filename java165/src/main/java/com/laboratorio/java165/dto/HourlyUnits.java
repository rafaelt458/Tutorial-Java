package com.laboratorio.java165.dto;

import com.google.gson.annotations.SerializedName;

public record HourlyUnits(
        String time,
        @SerializedName("temperature_2m")
        String temperature2m
        ) {
}