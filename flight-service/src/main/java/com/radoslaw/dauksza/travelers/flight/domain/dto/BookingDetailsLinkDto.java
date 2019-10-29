package com.radoslaw.dauksza.travelers.flight.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class BookingDetailsLinkDto {

    @JsonProperty("Uri")
    private String uri;

    @JsonProperty("Body")
    private String body;

    @JsonProperty("Method")
    private String method;
}
