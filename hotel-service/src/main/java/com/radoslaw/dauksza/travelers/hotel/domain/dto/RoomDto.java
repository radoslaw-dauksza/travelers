package com.radoslaw.dauksza.travelers.hotel.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RoomDto {

    @JsonProperty("bed_configurations")
    private List<BedConfigurationDto> bedConfigurationDtos;

    @JsonProperty("highlights")
    private List<HighlightDto> higlights;

    @JsonProperty("facilities")
    private List<FacilityDto> facilties;

    @JsonProperty("photos")
    private List<PhotoDto> photos;

    @JsonProperty("description")
    private String description;
}
