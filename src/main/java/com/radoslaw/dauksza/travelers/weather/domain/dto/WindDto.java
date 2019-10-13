package com.radoslaw.dauksza.travelers.weather.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class WindDto {

    @JsonProperty("speed")
    private Double speedInMetersPerSecond;

    @JsonProperty("deg")
    private Double deg;
}
