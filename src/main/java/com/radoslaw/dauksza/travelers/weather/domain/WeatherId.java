package com.radoslaw.dauksza.travelers.weather.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class WeatherId implements Serializable {
    private long id;
    private String icon;
}
