package com.radoslaw.dauksza.travelers.weather.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class City {
    @Id
    private long id;
    private String name;
    private double lat;
    private double lon;
    private String countryCode;
    private long timezoneShiftFromUtcInSeconds;
}
