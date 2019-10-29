package com.radoslaw.dauksza.travelers.hotel.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OptionDto {
    @JsonProperty("loading_message")
    private String loadingMessage;

    @JsonProperty("name")
    private String name;

    @JsonProperty("identifier")
    private String identifier;
}
