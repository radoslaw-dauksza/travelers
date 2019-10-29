package com.radoslaw.dauksza.travelers.event.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResultPage {
    private Result result;
    private int page;
    private long totalEntries;
    private byte perPage;
}
