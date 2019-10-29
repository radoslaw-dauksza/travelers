package com.radoslaw.dauksza.travelers.hotel.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookingHomeDto {

    @JsonProperty("is_single_unit_property")
    private boolean isSingleProperty;

    @JsonProperty("is_booking_home")
    private String isBookingHome;

    @JsonProperty("group")
    private String group;

    @JsonProperty("segment")
    private int segment;
}
