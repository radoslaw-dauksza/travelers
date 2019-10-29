package com.radoslaw.dauksza.travelers.weather.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ForecastForCityDto {

    @JsonProperty("city")
    private CityDto cityDto;

    @JsonProperty("cod")
    private String cod;

    @JsonProperty("message")
    private double message;

    @JsonProperty("cnt")
    private int cnt;

    @JsonProperty("list")
    private List<ForecastWeatherDto> forecastWeatherDtos = null;
}
