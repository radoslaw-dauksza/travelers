package com.radoslaw.dauksza.travelers.hotel.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BedTypeDto {

    @JsonProperty("bed_type")
    private int bedType;

    @JsonProperty("count")
    private int count;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;
}
