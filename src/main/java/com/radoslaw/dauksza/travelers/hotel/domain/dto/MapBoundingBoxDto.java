package com.radoslaw.dauksza.travelers.hotel.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MapBoundingBoxDto {

    @JsonProperty("sw_lat")
    private double swLat;

    @JsonProperty("ne_long")
    private double neLong;

    @JsonProperty("sw_long")
    private double swLong;

    @JsonProperty("ne_lat")
    private double neLat;
}
