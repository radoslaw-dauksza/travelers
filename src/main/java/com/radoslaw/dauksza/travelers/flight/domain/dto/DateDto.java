package com.radoslaw.dauksza.travelers.flight.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class DateDto {

    @JsonProperty("OutboundDates")
    private List<BoundDateDto> outBoundDates;

    @JsonProperty("InboundDates")
    private List<BoundDateDto> inboundDates;
}
