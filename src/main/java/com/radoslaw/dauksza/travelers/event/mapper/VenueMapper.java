package com.radoslaw.dauksza.travelers.event.mapper;

import com.radoslaw.dauksza.travelers.event.domain.Venue;
import com.radoslaw.dauksza.travelers.event.domain.dto.VenueDto;
import org.springframework.stereotype.Component;

@Component
public class VenueMapper {
    public Venue mapToVenue(VenueDto venueDto) {
        return new Venue(venueDto.getLon(),
                venueDto.getDisplayName(),
                venueDto.getLat(),
                venueDto.getId());
    }

    public VenueDto mapToVenueDto(Venue venue) {
        return new VenueDto(venue.getLon(),
                venue.getDisplayName(),
                venue.getLat(),
                venue.getId());
    }
}
