package com.radoslaw.dauksza.travelers.hotel.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BlockTextDto {

    @JsonProperty("policies")
    private List<PolicyDto> policies;
}
