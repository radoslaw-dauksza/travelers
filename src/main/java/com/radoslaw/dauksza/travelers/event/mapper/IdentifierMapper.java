package com.radoslaw.dauksza.travelers.event.mapper;

import com.radoslaw.dauksza.travelers.event.domain.Identifier;
import com.radoslaw.dauksza.travelers.event.domain.dto.IdentifierDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component("")
public class IdentifierMapper {
    public Identifier mapToIdentifier(IdentifierDto identifierDto) {
        return new Identifier(identifierDto.getMbid());
    }

    public IdentifierDto mapToIdentifierDto(Identifier identifier) {
        return new IdentifierDto(identifier.getMbid());
    }

    public List<Identifier> mapToIdentifiers(List<IdentifierDto> identifierDtos) {
        return identifierDtos.stream()
                .map(this::mapToIdentifier)
                .collect(Collectors.toList());
    }

    public List<IdentifierDto> mapToIdentifierDtos(List<Identifier> identifiers) {
        return identifiers.stream()
                .map(this::mapToIdentifierDto)
                .collect(Collectors.toList());
    }
}
