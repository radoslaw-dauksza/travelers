package com.radoslaw.dauksza.travelers.weather.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class ForecastWeather {
    @Id
    @GeneratedValue
    private long id;
    private long dateTimeUnixUtc;
    @OneToOne(cascade = CascadeType.ALL)
    private MainWeatherInfo mainWeatherInfo;
    @ManyToMany(targetEntity = Weather.class)
    private List<Weather> weathers = null;
    private int cloudinessInPercent;
    @OneToOne(cascade = CascadeType.ALL)
    private Wind wind;
    private String dateTimeUtcTxt;
    @OneToOne(cascade = CascadeType.ALL)
    private Snow snow;
    @OneToOne(cascade = CascadeType.ALL)
    private Rain rain;

    public ForecastWeather(long dateTimeUnixUtc, MainWeatherInfo mainWeatherInfo,
                           List<Weather> weathers, int cloudinessInPercent, Wind wind,
                           String dateTimeUtcTxt, Snow snow, Rain rain) {
        this.dateTimeUnixUtc = dateTimeUnixUtc;
        this.mainWeatherInfo = mainWeatherInfo;
        this.weathers = weathers;
        this.cloudinessInPercent = cloudinessInPercent;
        this.wind = wind;
        this.dateTimeUtcTxt = dateTimeUtcTxt;
        this.snow = snow;
        this.rain = rain;
    }
}
