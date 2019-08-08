package com.radoslaw.dauksza.travelers.weather.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class CityDto {

    @JsonProperty("id")
    private long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("coord")
    private CoordDto coordDto;
    @JsonProperty("country")
    private String countryCode;
    @JsonProperty("timezone")
    private long timezoneShiftFromUtcInSeconds;
    @JsonProperty("cod")
    private String cod;
    @JsonProperty("message")
    private double message;
    @JsonProperty("cnt")
    private int cnt;
    @JsonProperty("list")
    private List<ForecastWeatherDto> forecastWeatherDto = null;
}
