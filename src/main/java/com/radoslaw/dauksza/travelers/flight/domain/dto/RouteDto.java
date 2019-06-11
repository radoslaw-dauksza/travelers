package com.radoslaw.dauksza.travelers.flight.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class RouteDto {

    @JsonProperty("OriginId")
    private long originId;

    @JsonProperty("DestinationId")
    private long destinationId;

    @JsonProperty("QuoteIds")
    private List<Long> quoteIds;

    @JsonProperty("Price")
    private double price;

    @JsonProperty("QuoteDateTime")
    private LocalDateTime quoteDateTime;
}
