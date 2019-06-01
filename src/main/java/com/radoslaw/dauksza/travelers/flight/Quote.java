package com.radoslaw.dauksza.travelers.flight;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Currency;

@Getter(AccessLevel.PACKAGE)
@Setter(AccessLevel.PACKAGE)
@Entity
public class Quote {
    @Id
    @GeneratedValue
    @NotNull
    private long id;
    @NotNull
    private double minPrice;
    @NotNull
    private boolean direct;
    @NotNull
    private BoundLeg outboundLeg;
    @NotNull
    private BoundLeg inboundLeg;
    @NotNull
    private LocalDateTime quoteDateTime;
    @NotNull
    private Currency currency;
}
