package com.radoslaw.dauksza.travelers.flight.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Connection {
    @Id
    @GeneratedValue
    @NotNull
    private long id;
    @NotNull
    @ManyToMany(targetEntity = Carrier.class, fetch = FetchType.EAGER)
    private List<Carrier> carriers;
    @NotNull
    @OneToOne
    @JoinColumn
    private BrowsePlace origin;
    @NotNull
    @OneToOne
    @JoinColumn
    private BrowsePlace destination;
    @NotNull
    private LocalDate departureDate;

    public Connection(@NotNull List<Carrier> carriers,
               @NotNull BrowsePlace origin,
               @NotNull BrowsePlace destination,
               @NotNull LocalDate departureDate) {
        this.carriers = carriers;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
    }
}
