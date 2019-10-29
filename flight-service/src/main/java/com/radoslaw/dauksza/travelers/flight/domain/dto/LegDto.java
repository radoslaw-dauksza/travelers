package com.radoslaw.dauksza.travelers.flight.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class LegDto {

    @JsonProperty("Id")
    private String id;

    @JsonProperty("SegmentIds")
    private List<Long> segmentIds;

    @JsonProperty("OriginStation")
    private long originStationId;

    @JsonProperty("DestinationStation")
    private long destinationStationId;

    @JsonProperty("Departure")
    private LocalDateTime departure;

    @JsonProperty("Arrival")
    private LocalDateTime arrival;

    @JsonProperty("Duration")
    private long duration;

    @JsonProperty("JourneyMode")
    private String journeyMode;

    @JsonProperty("Stops")
    private List<Long> stopsIds;

    @JsonProperty("Carriers")
    private List<Long> carriersIds;

    @JsonProperty("OperatingCarriers")
    private List<Long> operatingCarriersIds;

    @JsonProperty("Directionality")
    private String directionality;

    @JsonProperty("FlightNumbers")
    private List<FlightNumbersDto> flightNumbersDtos;
}
