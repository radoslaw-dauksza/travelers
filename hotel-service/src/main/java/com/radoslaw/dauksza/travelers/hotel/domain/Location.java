package com.radoslaw.dauksza.travelers.hotel.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.net.URI;

@Data
@Entity(name = "locations")
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    private String cityUfi;
    private double longitude;
    private double latitude;
    private String cityName;
    private int hotels;
    private String region;
    @Id
    @NotNull
    private long destId;
    private String country;
    private URI imageUrl;
    private String label;
    private String type;
    private String name;
    @NotNull
    private String destType;
    private int nrHotels;
    private String timezone;
    private String lc;
    private int rtl;
    private String cc1;
}
