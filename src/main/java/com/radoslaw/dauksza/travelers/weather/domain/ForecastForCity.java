package com.radoslaw.dauksza.travelers.weather.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class ForecastForCity {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne(targetEntity = City.class, cascade = CascadeType.ALL)
    private City city;
    private String cod;
    private double message;
    private int cnt;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ForecastWeather> forecastWeathers = null;
    private LocalDateTime lastForecastingDateTime;

    public ForecastForCity(City city, String cod, double message,
                           int cnt, List<ForecastWeather> forecastWeathers,
                           LocalDateTime lastForecastingDateTime) {
        this.city = city;
        this.cod = cod;
        this.message = message;
        this.cnt = cnt;
        this.forecastWeathers = forecastWeathers;
        this.lastForecastingDateTime = lastForecastingDateTime;
    }
}
