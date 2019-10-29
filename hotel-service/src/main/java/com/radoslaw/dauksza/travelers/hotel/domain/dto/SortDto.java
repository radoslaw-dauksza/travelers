package com.radoslaw.dauksza.travelers.hotel.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SortDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;
}
