package com.radoslaw.dauksza.travelers.hotel.domain;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Entity
public class PropertyDescription {
    @Id
    @NotNull
    @GeneratedValue
    private long id;
    private long descriptionTypeId;
    private String languageCode;
    private String description;
    @OneToOne
    @JoinColumn
    private ExtraLines extraLines;

    public PropertyDescription(long descriptionTypeId, String languageCode, String description, ExtraLines extraLines) {
        this.descriptionTypeId = descriptionTypeId;
        this.languageCode = languageCode;
        this.description = description;
        this.extraLines = extraLines;
    }
}
