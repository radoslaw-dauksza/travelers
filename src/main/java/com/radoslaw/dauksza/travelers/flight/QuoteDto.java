package com.radoslaw.dauksza.travelers.flight;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class QuoteDto {

    @JsonProperty("QuoteId")
    private long quoteId;

    @JsonProperty("MinPrice")
    private double minPrice;

    @JsonProperty("Direct")
    private boolean direct;

    @JsonProperty("OutboundLeg")
    private OutboundLegDto outboundLeg;

    @JsonProperty("QuoteDateTime")
    private LocalDate quoteDateTime;
}
