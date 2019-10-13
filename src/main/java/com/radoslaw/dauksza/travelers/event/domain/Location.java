package com.radoslaw.dauksza.travelers.event.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@IdClass(LocationId.class)
public class Location {
    @Id
    private double lon;
    @Id
    private double lat;
    private String city;
}
