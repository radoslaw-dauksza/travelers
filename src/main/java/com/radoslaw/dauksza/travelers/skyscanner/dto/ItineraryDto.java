package com.radoslaw.dauksza.travelers.skyscanner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class ItineraryDto {

    @JsonProperty("OutboundLegId")
    private String outboundLegId;

    @JsonProperty("InboundLegId")
    private String inboundLegId;

    @JsonProperty("PricingOptions")
    private List<PricingOptionDto> pricingOptionDtos;

    @JsonProperty("BookingDetailsLink")
    private BookingDetailsLinkDto bookingDetailsLinkDto;
}
