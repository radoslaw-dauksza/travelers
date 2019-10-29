package com.radoslaw.dauksza.travelers.weather.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Entity
public class Snow {
    @Id
    @GeneratedValue
    private long id;
    private double volumeInLast3H;

    public Snow(double volumeInLast3H) {
        this.volumeInLast3H = volumeInLast3H;
    }
}
