package com.radoslaw.dauksza.travelers.event.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@IdClass(LocationId.class)
public class Venue {
    @Id
    private double lon;
    private String displayName;
    @Id
    private double lat;
    @Id
    @NotNull
    private long id;
}
