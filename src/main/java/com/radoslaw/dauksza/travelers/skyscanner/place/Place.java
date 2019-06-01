package com.radoslaw.dauksza.travelers.skyscanner.place;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Place {
    private String placeId;
    private String PlaceName;
    private String CountryId;
    private String regionId;
    private String cityId;
    private String countryName;

    @Id
    @NotNull
    String getPlaceId() {
        return placeId;
    }

    String getPlaceName() {
        return PlaceName;
    }

    String getCountryId() {
        return CountryId;
    }

    String getRegionId() {
        return regionId;
    }

    String getCityId() {
        return cityId;
    }

    String getCountryName() {
        return countryName;
    }
}
