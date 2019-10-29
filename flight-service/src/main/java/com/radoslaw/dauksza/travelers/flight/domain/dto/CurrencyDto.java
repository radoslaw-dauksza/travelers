package com.radoslaw.dauksza.travelers.flight.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyDto {

    @JsonProperty("Code")
    private String code;

    @JsonProperty("Symbol")
    private String symbol;
}
