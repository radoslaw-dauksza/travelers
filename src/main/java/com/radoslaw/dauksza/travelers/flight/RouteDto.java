package com.radoslaw.dauksza.travelers.flight;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

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
    private LocalDate quoteDateTime;
}
