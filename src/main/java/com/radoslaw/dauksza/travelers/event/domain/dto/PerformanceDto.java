package com.radoslaw.dauksza.travelers.event.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PerformanceDto {

    @JsonProperty("artist")
    private ArtistDto artistDto;

    @JsonProperty("displayName")
    private String displayName;

    @JsonProperty("billingIndex")
    private long billingIndex;

    @JsonProperty("id")
    private long id;

    @JsonProperty("billing")
    private String billing;
}
