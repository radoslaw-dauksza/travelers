package com.radoslaw.dauksza.travelers.hotel.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PropertiesListResponseDto {

    @JsonProperty("copyright")
    private List<String> copyrights;

    @JsonProperty("extended_count")
    private int extendedCount;

    @JsonProperty("map_bounding_box")
    private MapBoundingBoxDto mapBoundingBoxDto;

    @JsonProperty("sorting")
    private SortingDto sortingDto;

    @JsonProperty("unfiltered_primary_count")
    private int unfilteredPrimaryCount;

    @JsonProperty("count")
    private int count;

    @JsonProperty("sort")
    private List<SortDto> sortDtos;

    @JsonProperty("primary_count")
    private int primaryCount;

    @JsonProperty("search_radius")
    private int searchRadius;

    @JsonProperty("result")
    private List<ResultDto> resultDtos;

    @JsonProperty("is_beach_ufi")
    private int isBeachUfi;

    @JsonProperty("unfiltered_count")
    private int unfilteredCount;

    @JsonProperty("search_id")
    private String searchId;

    @JsonProperty("page_loading_threshold")
    private int pageLoadingTreshold;
}
