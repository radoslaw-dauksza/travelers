package com.radoslaw.dauksza.travelers.hotel.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PhotoDto {

    @JsonProperty("url_square60")
    private URI urlSquare60;

    @JsonProperty("url_original")
    private URI UrlOriginal;

    @JsonProperty("url_max300")
    private URI UrlMax300;

    @JsonProperty("url_640x200")
    private URI Url640x200;

    @JsonProperty("ratio")
    private double ratio;

    @JsonProperty("photo_id")
    private long photoId;
}
