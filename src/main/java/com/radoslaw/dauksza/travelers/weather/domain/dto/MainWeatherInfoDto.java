package com.radoslaw.dauksza.travelers.weather.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class MainWeatherInfoDto {

    @JsonProperty("temp")
    private double temp;
    @JsonProperty("temp_min")
    private double tempMin;
    @JsonProperty("temp_max")
    private double tempMax;
    @JsonProperty("pressure")
    private double defaultPressure;
    @JsonProperty("sea_level")
    private double seaLevelPressure;
    @JsonProperty("grnd_level")
    private double groundLevelPressure;
    @JsonProperty("humidity")
    private int humidity;
    @JsonProperty("temp_kf")
    private double tempKf;
}
