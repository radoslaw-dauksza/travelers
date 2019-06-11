package com.radoslaw.dauksza.travelers.flight.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Carrier {
    @Id
    @NotNull
    private long id;
    @NotNull
    private String name;
}
