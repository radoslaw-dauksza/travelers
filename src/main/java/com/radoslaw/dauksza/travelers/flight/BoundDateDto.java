package com.radoslaw.dauksza.travelers.flight;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class BoundDateDto {

    @JsonProperty("PartialDate")
    private LocalDate partialDate;

    @JsonProperty("QuoteIds")
    private List<Long> quoteIds;

    @JsonProperty("Price")
    private double price;

    @JsonProperty("QuoteDateTime")
    private LocalDateTime quoteDateTime;
}
