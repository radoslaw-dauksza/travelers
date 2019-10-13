package com.radoslaw.dauksza.travelers.event.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto {

    @JsonProperty("lng")
    private double lon;

    @JsonProperty("lat")
    private double lat;

    @JsonProperty("city")
    private String city;
}
