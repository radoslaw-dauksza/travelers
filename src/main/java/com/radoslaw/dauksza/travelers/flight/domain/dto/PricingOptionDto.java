package com.radoslaw.dauksza.travelers.flight.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
public class PricingOptionDto {

    @JsonProperty("Agents")
    private List<AgentDto> agentDtos;

    @JsonProperty("QuoteAgeInMinutes")
    private int quoteAgeInMinutes;

    @JsonProperty("Price")
    private BigDecimal price;

    @JsonProperty("DeepLinkUrl")
    private String deepLinkUrl;
}
