package com.radoslaw.dauksza.travelers.hotel.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookedRoomDetailsBookingHomeDto {

    @JsonProperty("checkin_methods")
    private List<CheckinMethodDto> checkinMethodDtos;

    @JsonProperty("group")
    private String group;
}
