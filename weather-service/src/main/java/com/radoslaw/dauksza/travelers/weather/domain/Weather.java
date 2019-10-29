package com.radoslaw.dauksza.travelers.weather.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@IdClass(WeatherId.class)
public class Weather {
    @Id
    private long id;
    private String main;
    private String description;
    @Id
    private String icon;
}
