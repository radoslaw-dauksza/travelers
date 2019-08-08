package com.radoslaw.dauksza.travelers.weather.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CloudinessDto {

    @JsonProperty("all")
    private int CloudinessInPercent;
}
