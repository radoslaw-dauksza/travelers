package com.radoslaw.dauksza.travelers.event.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResultDto {

    @JsonProperty("event")
    private List<EventDto> eventDto = null;
}
