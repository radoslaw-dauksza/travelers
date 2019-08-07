package com.radoslaw.dauksza.travelers.hotel.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PropertyDescriptionDto {

    @JsonProperty("descriptiontype_id")
    private long descriptionTypeId;

    @JsonProperty("languagecode")
    private String languageCode;

    @JsonProperty("description")
    private String description;

    @JsonProperty("extra_lines")
    private ExtraLinesDto extraLinesDto;
}
