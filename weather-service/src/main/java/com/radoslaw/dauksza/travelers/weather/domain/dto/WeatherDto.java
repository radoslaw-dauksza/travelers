package com.radoslaw.dauksza.travelers.weather.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class WeatherDto {

    @JsonProperty("id")
    private long id;

    @JsonProperty("main")
    private String main;

    @JsonProperty("description")
    private String description;

    @JsonProperty("icon")
    private String icon;
}
