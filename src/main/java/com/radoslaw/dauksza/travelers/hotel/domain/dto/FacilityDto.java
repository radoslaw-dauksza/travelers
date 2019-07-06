package com.radoslaw.dauksza.travelers.hotel.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FacilityDto {

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;
}
