package com.radoslaw.dauksza.travelers.hotel.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthorDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("countrycode")
    private String countryCode;

    @JsonProperty("type")
    private String type;
}
