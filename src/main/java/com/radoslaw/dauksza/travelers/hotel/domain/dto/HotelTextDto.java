package com.radoslaw.dauksza.travelers.hotel.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class HotelTextDto {

    @JsonProperty("important_information")
    private String importantInformation;

    @JsonProperty("policies")
    private List<PolicyDto> policies;
}
