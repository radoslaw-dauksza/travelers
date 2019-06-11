package com.radoslaw.dauksza.travelers.flight.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class BoundLegDto {

    @JsonProperty("CarrierIds")
    private List<Long> carrierIds;

    @JsonProperty("OriginId")
    private long originId;

    @JsonProperty("DestinationId")
    private long destinationId;

    @JsonProperty("DepartureDate")
    private LocalDateTime departureDate;
}
