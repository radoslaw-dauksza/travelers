package com.radoslaw.dauksza.travelers.flight.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ConnectionDto {

    @JsonProperty("CarrierIds")
    private List<Long> carrierIds;

    @JsonProperty("OriginId")
    private long originId;

    @JsonProperty("DestinationId")
    private long destinationId;

    @JsonProperty("DepartureDate")
    private LocalDate departureDate;
}
