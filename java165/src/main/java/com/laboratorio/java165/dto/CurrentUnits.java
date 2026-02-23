package com.laboratorio.java165.dto;

import com.google.gson.annotations.SerializedName;

public record CurrentUnits(
        String time,
        String interval,
        @SerializedName("temperature_2m")
        String temperature2m
        ) {
}