package com.radoslaw.dauksza.travelers.event.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class EventDto {

    @JsonProperty("displayName")
    private String displayName;

    @JsonProperty("type")
    private String type;

    @JsonProperty("uri")
    private URI uri;

    @JsonProperty("venue")
    private VenueDto venueDto;

    @JsonProperty("location")
    private LocationDto locationDto;

    @JsonProperty("start")
    private StartDto startDto;

    @JsonProperty("performance")
    private List<PerformanceDto> performanceDtos = null;

    @JsonProperty("id")
    private long id;
}
