package com.radoslaw.dauksza.travelers.skyscanner.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class AgentDto {

    @JsonProperty("Id")
    private long id;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("ImageUrl")
    private String imageUrl;

    @JsonProperty("Status")
    private String status;

    @JsonProperty("OptimisedForMobile")
    private boolean optimisedForMobile;

    @JsonProperty("Type")
    private String type;
}
