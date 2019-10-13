package com.radoslaw.dauksza.travelers.event.domain;

import lombok.*;

import java.io.Serializable;

@Data
public class LocationId implements Serializable {
    private double lon;
    private double lat;
}
