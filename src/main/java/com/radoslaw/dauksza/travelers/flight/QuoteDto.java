package com.radoslaw.dauksza.travelers.flight;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class QuoteDto {

    @JsonProperty("QuoteId")
    private long quoteId;

    @JsonProperty("MinPrice")
    private double minPrice;

    @JsonProperty("Direct")
    private boolean direct;

    @JsonProperty("OutboundLeg")
    private BoundLegDto outboundLeg;

    @JsonProperty("InboundLeg")
    private BoundLegDto inboundLeg;

    @JsonProperty("QuoteDateTime")
    private LocalDateTime quoteDateTime;
}
