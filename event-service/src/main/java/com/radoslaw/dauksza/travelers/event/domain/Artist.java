package com.radoslaw.dauksza.travelers.event.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Artist {
    private URI uri;
    private String displayName;
    @Id
    @NotNull
    private long id;
    @OneToMany
    private List<Identifier> identifier = null;
}
