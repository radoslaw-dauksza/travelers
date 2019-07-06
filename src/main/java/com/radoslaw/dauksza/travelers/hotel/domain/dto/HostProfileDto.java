package com.radoslaw.dauksza.travelers.hotel.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HostProfileDto {

    @JsonProperty("host_info_eligible_to_be_shown")
    private boolean hostInfoEligibleToBeShown;

    @JsonProperty("host_score")
    private double hostScore;

    @JsonProperty("host_joined_booking")
    private LocalDate hostJoinedBooking;

    @JsonProperty("languages_spoken_by_hotelier")
    private List<HostLanguageDto> languagesSpokenByHotelier;

    @JsonProperty("photo_width")
    private int photoWidth;

    @JsonProperty("photo_height")
    private int photoHeight;

    @JsonProperty("host_is_pro")
    private boolean hostIsPro;

    @JsonProperty("host_name")
    private String hostName;

    @JsonProperty("about_property")
    private String aboutProperty;

    @JsonProperty("about_neighborhood")
    private String aboutNeighborhood;

    @JsonProperty("hotel")
    private HotelDto hotel;

    @JsonProperty("about_host")
    private String aboutHost;

    @JsonProperty("photo_max500_url")
    private URI photoMax500Url;

    @JsonProperty("host_featured_reviews")
    private List<HostFeaturedReviewDto> hostFeaturedReviewDtos;

    @JsonProperty("url_prefix")
    private URI urlPrefix;

    @JsonProperty("is_company_profile")
    private boolean isCompanyProfile;

    @JsonProperty("name_or_company")
    private String nameOrCompany;

    @JsonProperty("host_score_count")
    private int hostScoreCount;
}
