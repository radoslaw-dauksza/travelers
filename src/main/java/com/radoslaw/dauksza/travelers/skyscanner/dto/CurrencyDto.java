package com.radoslaw.dauksza.travelers.skyscanner.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyDto {

    @JsonProperty("Code")
    private String code;

    @JsonProperty("Symbol")
    private String symbol;
}
