package com.radoslaw.dauksza.travelers.hotel.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HotelDto {

    @JsonProperty("checkin_until")
    private String checkinUntil;

    @JsonProperty("default_communication_language")
    private String defaultComunicationLanguage;

    @JsonProperty("city")
    private String city;

    @JsonProperty("name")
    private String name;

    @JsonProperty("currencycode")
    private String currencyCode;

    @JsonProperty("id")
    private long id;

    @JsonProperty("checkout_until")
    private String checkoutUntil;

    @JsonProperty("ufi")
    private long ufi;

    @JsonProperty("name_unidecode")
    private String nameUnicode;

    @JsonProperty("checkin")
    private String checkin;

    @JsonProperty("checkout")
    private String checkout;

    @JsonProperty("address")
    private String address;

    @JsonProperty("latitude")
    private double latitude;

    @JsonProperty("longitude")
    private double longitude;

    @JsonProperty("nr_rooms")
    private int nrRooms;
}
