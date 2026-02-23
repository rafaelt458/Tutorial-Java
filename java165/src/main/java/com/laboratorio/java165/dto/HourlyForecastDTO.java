package com.laboratorio.java165.dto;

import com.google.gson.annotations.SerializedName;

public record HourlyForecastDTO(
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
        @SerializedName("hourly_units")
        HourlyUnits hourlyUnits,
        Hourly hourly
        ) {
}