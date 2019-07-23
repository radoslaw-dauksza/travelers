package com.radoslaw.dauksza.travelers.hotel.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalTime;

@Getter
@AllArgsConstructor
public class HoursDto {

    @JsonProperty("from")
    private LocalTime from;

    @JsonProperty("until")
    private LocalTime until;
}
