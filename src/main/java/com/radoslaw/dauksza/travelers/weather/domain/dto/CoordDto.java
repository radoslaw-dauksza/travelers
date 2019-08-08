package com.radoslaw.dauksza.travelers.weather.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CoordDto {

    @JsonProperty("lon")
    private double lon;
    @JsonProperty("lat")
    private double lat;
}
