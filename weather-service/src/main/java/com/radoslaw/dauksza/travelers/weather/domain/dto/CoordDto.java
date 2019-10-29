package com.radoslaw.dauksza.travelers.weather.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CoordDto {

    @JsonProperty("lon")
    private double lon;

    @JsonProperty("lat")
    private double lat;
}
