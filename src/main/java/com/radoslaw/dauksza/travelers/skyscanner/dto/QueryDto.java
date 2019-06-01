package com.radoslaw.dauksza.travelers.skyscanner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDate;
@Getter
public class QueryDto {

    @JsonProperty("Country")
    private String country;

    @JsonProperty("Currency")
    private String currency;

    @JsonProperty("Locale")
    private String locale;

    @JsonProperty("Adults")
    private int adults;

    @JsonProperty("Children")
    private int children;

    @JsonProperty("Infants")
    private int infants;

    @JsonProperty("OriginPlace")
    private long originPlaceId;

    @JsonProperty("OutboundDate")
    private LocalDate outboundDate;

    @JsonProperty("InboundDate")
    private LocalDate inboundDate;

    @JsonProperty("LocalisationSchema")
    private String locationSchema;

    @JsonProperty("cabinClass")
    private String cabinClass;

    @JsonProperty("GroupPricing")
    private boolean groupPricing;
}
