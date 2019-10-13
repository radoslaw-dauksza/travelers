package com.radoslaw.dauksza.travelers.event.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VenueDto {

    @JsonProperty("lng")
    private double lon;

    @JsonProperty("displayName")
    private String displayName;

    @JsonProperty("lat")
    private double lat;

    @JsonProperty("id")
    private long id;
}
