package com.radoslaw.dauksza.travelers.flight;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class OutboundLegDto {

    @JsonProperty("CarrierIds")
    List<Long> carrierIds;

    @JsonProperty("OriginId")
    long originId;

    @JsonProperty("DestinationId")
    long destinationId;

    @JsonProperty("DepartureDate")
    LocalDate departureDate;
}
