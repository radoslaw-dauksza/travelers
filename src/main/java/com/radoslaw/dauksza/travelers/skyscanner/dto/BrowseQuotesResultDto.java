package com.radoslaw.dauksza.travelers.skyscanner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BrowseQuotesResultDto {

    @JsonProperty("Quotes")
    private List<QuoteDto> quotes = new ArrayList<>();

    @JsonProperty("Places")
    private List<AutosuggestPlaceDto> places = new ArrayList<>();

    @JsonProperty("Carriers")
    private List<BrowseCarrierDto> carriers = new ArrayList<>();

    @JsonProperty("Currencies")
    private List<CurrencyDto> currencies = new ArrayList<>();
}