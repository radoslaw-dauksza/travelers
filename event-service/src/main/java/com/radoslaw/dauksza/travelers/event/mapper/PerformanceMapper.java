package com.radoslaw.dauksza.travelers.event.mapper;

import com.radoslaw.dauksza.travelers.event.domain.Performance;
import com.radoslaw.dauksza.travelers.event.domain.dto.PerformanceDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PerformanceMapper {
    private final ArtistMapper artistMapper;

    public PerformanceMapper(ArtistMapper artistMapper) {
        this.artistMapper = artistMapper;
    }

    public Performance mapToPerformance(PerformanceDto performanceDto) {
        return new Performance(artistMapper.mapToArtist(performanceDto.getArtistDto()),
                performanceDto.getDisplayName(),
                performanceDto.getBillingIndex(),
                performanceDto.getId(),
                performanceDto.getBilling());
    }

    public PerformanceDto mapToPerformanceDto(Performance performance) {
        return new PerformanceDto(artistMapper.mapToArtistDto(performance.getArtist()),
                performance.getDisplayName(),
                performance.getBillingIndex(),
                performance.getId(),
                performance.getBilling());
    }

    public List<Performance> mapToPerformances(List<PerformanceDto> performanceDtos) {
        return performanceDtos.parallelStream()
                .map(this::mapToPerformance)
                .collect(Collectors.toList());
    }
    public List<PerformanceDto> mapToPerformanceDtos(List<Performance> performances) {
        return performances.parallelStream()
                .map(this::mapToPerformanceDto)
                .collect(Collectors.toList());
    }
}
