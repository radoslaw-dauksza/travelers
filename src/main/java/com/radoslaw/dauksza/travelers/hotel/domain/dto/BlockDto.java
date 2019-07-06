package com.radoslaw.dauksza.travelers.hotel.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BlockDto {

    @JsonProperty("block_id")
    private String blockId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("room_id")
    private long roomId;

    @JsonProperty("room_surface_in_feet2")
    private double roomSurfaceInFeet2;

    @JsonProperty("room_surface_in_m2")
    private double roomSurfaceInm2;

    @JsonProperty("room_count")
    private int roomCount;

    @JsonProperty("max_children_free")
    private int maxChildrenFree;

    @JsonProperty("max_occupancy")
    private int maxOcupancy;

    @JsonProperty("all_inclusive")
    private boolean allInclusive;

    @JsonProperty("breakfast_included")
    private boolean breakfastIncluded;

    @JsonProperty("mealplan")
    private String mealplan;

    @JsonProperty("number_of_bathrooms")
    private int numberOfBathrooms;

    @JsonProperty("block_text")
    private BlockTextDto blockTextDto;

    @JsonProperty("deposit_required")
    private boolean depositRequired;
}
