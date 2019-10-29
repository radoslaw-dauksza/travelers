package com.radoslaw.dauksza.travelers.hotel.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.net.URI;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto {

    @JsonProperty("city_ufi")
    private String cityUfi;

    @JsonProperty("longitude")
    private double longitude;

    @JsonProperty("latitude")
    private double latitude;

    @JsonProperty("city_name")
    private String cityName;

    @JsonProperty("hotels")
    private int hotels;

    @JsonProperty("region")
    private String region;

    @JsonProperty("dest_id")
    private long destId;

    @JsonProperty("country")
    private String country;

    @JsonProperty("image_url")
    private URI imageUrl;

    @JsonProperty("label")
    private String label;

    @JsonProperty("type")
    private String type;

    @JsonProperty("name")
    private String name;

    @JsonProperty("dest_type")
    private String destType;

    @JsonProperty("nr_hotels")
    private int nrHotels;

    @JsonProperty("timezone")
    private String timezone;

    @JsonProperty("lc")
    private String lc;

    @JsonProperty("rtl")
    private int rtl;

    @JsonProperty("cc1")
    private String cc1;
}
