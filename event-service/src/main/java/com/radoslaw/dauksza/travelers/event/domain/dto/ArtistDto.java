package com.radoslaw.dauksza.travelers.event.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class ArtistDto {

    @JsonProperty("uri")
    private URI uri;

    @JsonProperty("displayName")
    private String displayName;

    @JsonProperty("id")
    private long id;

    @JsonProperty("identifier")
    private List<IdentifierDto> identifierDto = null;
}
