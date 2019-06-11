package com.radoslaw.dauksza.travelers.flight.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class FlightQuoteDto {

    @JsonProperty("QuoteId")
    private long quoteId;

    @JsonProperty("MinPrice")
    private double minPrice;

    @JsonProperty("Direct")
    private boolean direct;

    @JsonProperty("OutboundConnection")
    private ConnectionDto outboundConnection;

    @JsonProperty("InboundConnection")
    private ConnectionDto inboundConnection;

    @JsonProperty("QuoteDateTime")
    private LocalDateTime quoteDateTime;

    @JsonProperty("QuoteCurrency")
    private CurrencyDto currencyid;
}
