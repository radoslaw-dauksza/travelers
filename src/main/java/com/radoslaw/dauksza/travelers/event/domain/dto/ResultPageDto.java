package com.radoslaw.dauksza.travelers.event.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResultPageDto {

    @JsonProperty("results")
    private ResultDto resultDto;

    @JsonProperty("page")
    private int page;

    @JsonProperty("totalEntries")
    private long totalEntries;

    @JsonProperty("perPage")
    private byte perPage;
}
