package com.radoslaw.dauksza.travelers.weather.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class ForecastWeatherDto {

    @JsonProperty("dt")
    private long dateTimeUnixUtc;
    @JsonProperty("main")
    private MainWeatherInfoDto mainWeatherInfoDto;
    @JsonProperty("weather")
    private List<WeatherDto> weatherDto = null;
    @JsonProperty("clouds")
    private CloudinessDto cloudinessDto;
    @JsonProperty("wind")
    private WindDto windDto;
    @JsonProperty("sys")
    private SysDto sysDto;
    @JsonProperty("dt_txt")
    private String dateTimeUtcTxt;
}
