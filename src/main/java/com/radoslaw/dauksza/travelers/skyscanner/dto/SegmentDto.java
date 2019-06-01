package com.radoslaw.dauksza.travelers.skyscanner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SegmentDto {

    @JsonProperty("Id")
    private long id;

    @JsonProperty("OriginStation")
    private long originStationId;

    @JsonProperty("DestinationStation")
    private long destinationStationId;

    @JsonProperty("DepartureDateTime")
    private LocalDateTime departureDateTime;

    @JsonProperty("ArrivalDateTime")
    private LocalDateTime arrivalDateTime;

    @JsonProperty("Carrier")
    private long carrierId;

    @JsonProperty("OperatingCarrier")
    private long OperatingCarrierId;

    @JsonProperty("Duration")
    private long duration;

    @JsonProperty("FlightNumber")
    private String flightNumber;

    @JsonProperty("JourneyMode")
    private String journeyMode;

    @JsonProperty("Directionality")
    private String directionality;
}
