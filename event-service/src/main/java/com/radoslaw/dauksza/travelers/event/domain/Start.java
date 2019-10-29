package com.radoslaw.dauksza.travelers.event.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.*;

@Entity
@Getter
@NoArgsConstructor
public class Start {
    private LocalTime time;
    private LocalDate date;
    private ZonedDateTime datetime;
    @Id
    @NotNull
    @GeneratedValue
    private long id;

    public Start(LocalTime time, LocalDate date, ZonedDateTime datetime) {
        this.time = time;
        this.date = date;
        this.datetime = datetime;
    }
}
