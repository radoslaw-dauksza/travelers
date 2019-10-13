package com.radoslaw.dauksza.travelers.event.mapper;

import com.radoslaw.dauksza.travelers.event.domain.ResultPage;
import com.radoslaw.dauksza.travelers.event.domain.dto.ResultPageDto;
import org.springframework.stereotype.Component;

@Component
public class ResultPageMapper {
    private final ResultMapper resultMapper;

    public ResultPageMapper(ResultMapper resultMapper) {
        this.resultMapper = resultMapper;
    }

    public ResultPage mapToResultPage(ResultPageDto resultPageDto) {
        return new ResultPage(resultMapper.mapToResult(resultPageDto.getResultDto()),
                resultPageDto.getPage(),
                resultPageDto.getTotalEntries(),
                resultPageDto.getPerPage());
    }

    public ResultPageDto mapToResultPageDto(ResultPage resultPage) {
        return new ResultPageDto(resultMapper.mapToResultDtos(resultPage.getResult()),
                resultPage.getPage(),
                resultPage.getTotalEntries(),
                resultPage.getPerPage());
    }
}
