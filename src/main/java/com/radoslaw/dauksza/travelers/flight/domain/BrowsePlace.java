package com.radoslaw.dauksza.travelers.flight.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class BrowsePlace {
    @Id
    @NotNull
    private long placeId;
    private String iataCode;
    @NotNull
    private String name;
    private String type;
    private String skyscannerCode;
    private String cityName;
    private String cityId;
    private String countryName;
}
