package com.radoslaw.dauksza.travelers.hotel.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingHomeDto {

    @JsonProperty("is_single_unit_property")
    private boolean isSinglePropperty;

    @JsonProperty("is_booking_home")
    private String isBookingHome;

    @JsonProperty("group")
    private String group;

    @JsonProperty("segment")
    private int segment;
}
