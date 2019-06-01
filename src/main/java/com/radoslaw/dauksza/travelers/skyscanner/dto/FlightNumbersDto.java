package com.radoslaw.dauksza.travelers.skyscanner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class FlightNumbersDto {

    @JsonProperty("FlightNumber")
    private String flightNumber;

    @JsonProperty("CarrierId")
    private long carrierId;
}
