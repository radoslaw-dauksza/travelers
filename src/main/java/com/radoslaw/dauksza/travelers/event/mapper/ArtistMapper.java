package com.radoslaw.dauksza.travelers.event.mapper;

import com.radoslaw.dauksza.travelers.event.domain.Artist;
import com.radoslaw.dauksza.travelers.event.domain.dto.ArtistDto;
import org.springframework.stereotype.Component;

@Component
public class ArtistMapper {
    private final IdentifierMapper identifierMapper;

    public ArtistMapper(IdentifierMapper identifierMapper) {
        this.identifierMapper = identifierMapper;
    }

    public Artist mapToArtist(ArtistDto artistDto) {
        return new Artist(artistDto.getUri(),
                artistDto.getDisplayName(),
                artistDto.getId(),
                identifierMapper.mapToIdentifiers(artistDto.getIdentifierDto()));
    }

    public ArtistDto mapToArtistDto(Artist artist) {
        return new ArtistDto(artist.getUri(),
                artist.getDisplayName(),
                artist.getId(),
                identifierMapper.mapToIdentifierDtos(artist.getIdentifier()));
    }
}
