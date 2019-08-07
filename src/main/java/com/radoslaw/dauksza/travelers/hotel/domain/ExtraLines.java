package com.radoslaw.dauksza.travelers.hotel.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Getter
@Entity
@NoArgsConstructor
public class ExtraLines {
    @Id
    @NotNull
    @GeneratedValue
    private long id;
    private String impInfo;

    public ExtraLines(String impInfo) {
        this.impInfo = impInfo;
    }
}
