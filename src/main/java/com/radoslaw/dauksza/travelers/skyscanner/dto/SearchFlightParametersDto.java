package com.radoslaw.dauksza.travelers.skyscanner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Setter
@Getter
public class SearchFlightParametersDto {

    @JsonProperty(value = "country", defaultValue = "PL")
    private String country;

    @JsonProperty(value = "currency", defaultValue = "pln")
    private String currency;

    @JsonProperty(value = "locale", defaultValue = "pl-PL")
    private String locale;

    @JsonProperty(value = "originPlace", required = true)
    private String originPlace;

    @JsonProperty(value = "destinationPlace", required = true)
    private String destinationPlace;

    @NotNull
    @JsonProperty(value = "outboundDate", required = true)
    private LocalDate outboundDate;

    @JsonProperty("inboundDate")
    private LocalDate inboundDate;
}
