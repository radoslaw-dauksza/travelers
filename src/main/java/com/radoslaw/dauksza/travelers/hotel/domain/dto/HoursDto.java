package com.radoslaw.dauksza.travelers.hotel.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalTime;

public class HoursDto {

    @JsonProperty("from")
    private LocalTime from;

    @JsonProperty("until")
    private LocalTime until;
}
