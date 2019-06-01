package com.radoslaw.dauksza.travelers.skyscanner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class FlightLivePricesResponseDto {

    @JsonProperty("SessionKey")
    private String sessionKey;

    @JsonProperty("Query")
    private QueryDto queryDto;

    @JsonProperty("Status")
    private String status;

    @JsonProperty("Itineraries")
    private List<ItineraryDto> itineraries;

    @JsonProperty("Legs")
    private List<LegDto> legs;

    @JsonProperty("Segments")
    private List<SegmentDto> segmentDtos;

    @JsonProperty("Carriers")
    private List<LivePriceCarrierDto> livePriceCarrierDtos;

    @JsonProperty("Agents")
    private List<AgentDto> agentDtos;

    @JsonProperty("Places")
    private List<AutosuggestPlaceDto> placeDtos;
}
