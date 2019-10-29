package com.radoslaw.dauksza.travelers.event.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Performance {
    @ManyToOne
    private Artist artist;
    private String displayName;
    private long billingIndex;
    @Id
    @NotNull
    private long id;
    private String billing;
}
