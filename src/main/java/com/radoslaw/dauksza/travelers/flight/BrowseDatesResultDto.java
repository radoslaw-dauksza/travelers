package com.radoslaw.dauksza.travelers.flight;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BrowseDatesResultDto {

    @JsonProperty("Dates")
    private List<DateDto> dates = new ArrayList<>();

    @JsonProperty("Quotes")
    private List<QuoteDto> quotes = new ArrayList<>();

    @JsonProperty("Places")
    private List<PlaceDto> places = new ArrayList<>();

    @JsonProperty("Carriers")
    private List<CarrierDto> carriers = new ArrayList<>();

    @JsonProperty("Currencies")
    private List<CurrencyDto> currencies = new ArrayList<>();
}
