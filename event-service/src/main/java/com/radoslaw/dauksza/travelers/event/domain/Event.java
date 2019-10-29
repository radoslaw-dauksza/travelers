package com.radoslaw.dauksza.travelers.event.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
public class Event {
    private String displayName;
    private String type;
    private URI uri;
    @OneToOne
    private Venue venue;
    @OneToOne
    private Location location;
    @OneToOne
    private Start start;
    @OneToMany
    private List<Performance> performances = null;
    @Id
    @NotNull
    private long id;
}
