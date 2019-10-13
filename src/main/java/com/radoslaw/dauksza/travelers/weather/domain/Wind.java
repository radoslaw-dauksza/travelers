package com.radoslaw.dauksza.travelers.weather.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Entity
public class Wind {
    @Id
    @GeneratedValue
    private long id;
    private Double speedInMetersPerSecond;
    private Double deg;

    public Wind(Double speedInMetersPerSecond, Double deg) {
        this.speedInMetersPerSecond = speedInMetersPerSecond;
        this.deg = deg;
    }
}
