package com.radoslaw.dauksza.travelers.flight;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Getter(AccessLevel.PACKAGE)
@Setter(AccessLevel.PACKAGE)
@Entity
public class Place {
    @Id
    @NotNull
    @Column(length = 10)
    private String placeId;
    @NotNull
    private String PlaceName;
    private String CountryId;
    private String regionId;
    private String cityId;
    private String countryName;
}
