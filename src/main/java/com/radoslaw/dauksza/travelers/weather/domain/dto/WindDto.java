package com.radoslaw.dauksza.travelers.weather.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class WindDto {

    @JsonProperty("speed")
    private Double speed;
    @JsonProperty("deg")
    private Double deg;
}
