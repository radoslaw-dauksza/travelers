package com.radoslaw.dauksza.travelers.hotel.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PolicyDto {

    @JsonProperty("class")
    private String cls;

    @JsonProperty("content")
    private String content;

    @JsonProperty("currencycode")
    private String currencyCode;

    @JsonProperty("price")
    private double price;

    @JsonProperty("items")
    private List<String> items;
}
