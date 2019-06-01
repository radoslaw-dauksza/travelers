package com.radoslaw.dauksza.travelers.flight;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Getter(AccessLevel.PACKAGE)
@Setter(AccessLevel.PACKAGE)
@Entity
public class Carrier {
    @Id
    @NotNull
    private long id;
    @NotNull
    private String name;
}
