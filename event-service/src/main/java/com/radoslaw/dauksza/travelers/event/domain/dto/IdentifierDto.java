package com.radoslaw.dauksza.travelers.event.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class IdentifierDto {

    @JsonProperty("mbid")
    private String mbid;
}
