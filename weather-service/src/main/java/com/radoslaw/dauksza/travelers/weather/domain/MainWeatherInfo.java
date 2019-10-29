package com.radoslaw.dauksza.travelers.weather.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Entity
public class MainWeatherInfo {
    @Id
    @GeneratedValue
    private long id;
    private double temp;
    private double tempMin;
    private double tempMax;
    private double defaultPressure;
    private double seaLevelPressure;
    private double groundLevelPressure;
    private int humidity;
    private double tempKf;

    public MainWeatherInfo(double temp, double tempMin, double tempMax,
                           double defaultPressure, double seaLevelPressure,
                           double groundLevelPressure, int humidity, double tempKf) {
        this.temp = temp;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.defaultPressure = defaultPressure;
        this.seaLevelPressure = seaLevelPressure;
        this.groundLevelPressure = groundLevelPressure;
        this.humidity = humidity;
        this.tempKf = tempKf;
    }
}
