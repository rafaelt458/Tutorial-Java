package com.laboratorio.java165.dto;

import com.google.gson.annotations.SerializedName;

public record CurrentForecastDTO(
        double latitude,
        double longitude,
        @SerializedName("generationtime_ms")
        double generationtimeMs,
        @SerializedName("utc_offset_seconds")
        int utcOffsetSeconds,
        String timezone,
        @SerializedName("timezone_abbreviation")
        String timezoneAbbreviation,
        double elevation,
        @SerializedName("current_units")
        CurrentUnits currentUnits,
        Current current
        ) {
}