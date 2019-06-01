package com.radoslaw.dauksza.travelers.flight;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter(AccessLevel.PACKAGE)
@Setter(AccessLevel.PACKAGE)
@Entity
public class BoundLeg {
    @Id
    @GeneratedValue
    @NotNull
    private long id;
    @NotNull
    private List<Carrier> carriers;
    @NotNull
    private Place origin;
    @NotNull
    private Place Destination;
    @NotNull
    private LocalDate departureDate;
}
