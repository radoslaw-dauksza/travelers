package com.radoslaw.dauksza.travelers.weather.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ForecastWeatherDto {

    @JsonProperty("dt")
    private long dateTimeUnixUtc;

    @JsonProperty("main")
    private MainWeatherInfoDto mainWeatherInfoDto;

    @JsonProperty("weather")
    private List<WeatherDto> weatherDtos = null;

    @JsonProperty("clouds")
    private CloudinessDto cloudinessDto;

    @JsonProperty("wind")
    private WindDto windDto;

    @JsonProperty("dt_txt")
    private String dateTimeUtcTxt;

    @JsonProperty("snow")
    private SnowDto snowDto;

    @JsonProperty("rain")
    private RainDto rainDto;
}
