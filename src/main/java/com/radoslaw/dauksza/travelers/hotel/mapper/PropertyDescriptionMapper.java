package com.radoslaw.dauksza.travelers.hotel.mapper;

import com.radoslaw.dauksza.travelers.hotel.domain.ExtraLines;
import com.radoslaw.dauksza.travelers.hotel.domain.PropertyDescription;
import com.radoslaw.dauksza.travelers.hotel.domain.dto.PropertyDescriptionDto;
import org.springframework.stereotype.Component;

@Component
public class PropertyDescriptionMapper {
    private ExtraLinesMapper extraLinesMapper;

    public PropertyDescriptionMapper(ExtraLinesMapper extraLinesMapper) {
        this.extraLinesMapper = extraLinesMapper;
    }

    public PropertyDescription mapToPropertyDescription(PropertyDescriptionDto propertyDescriptionDto) {
        ExtraLines extraLines = extraLinesMapper.mapToExtraLines(propertyDescriptionDto.getExtraLinesDto());
        return new PropertyDescription(
                propertyDescriptionDto.getDescriptionTypeId(),
                propertyDescriptionDto.getLanguageCode(),
                propertyDescriptionDto.getDescription(),
                extraLines);
    }

    public PropertyDescriptionDto mapToPropertyDescriptionDto(PropertyDescription propertyDescription) {
        return new PropertyDescriptionDto(
                propertyDescription.getDescriptionTypeId(),
                propertyDescription.getLanguageCode(),
                propertyDescription.getDescription(),
                extraLinesMapper.mapToExtraLinesDto(propertyDescription.getExtraLines()));
    }
}
