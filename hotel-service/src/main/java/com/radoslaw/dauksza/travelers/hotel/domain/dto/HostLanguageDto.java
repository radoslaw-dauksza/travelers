package com.radoslaw.dauksza.travelers.hotel.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HostLanguageDto {

    @JsonProperty("lang_code")
    private String langCode;

    @JsonProperty("is_country_language")
    private boolean isCountryLanguage;
}
