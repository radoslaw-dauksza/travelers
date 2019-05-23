package com.radoslaw.dauksza.travelers.flight;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.YearMonth;


@Getter
@Setter
public class FlightParametersDto {
    @NotNull
    private String country = "PL";
    @NotNull
    private String currency = "pln";
    @NotNull
    private String locale = "pl-PL";
    @NotNull
    private String originPlace;
    @NotNull
    private String destinationPlace;
    @NotNull
    private YearMonth outboundPartialDate;
    private YearMonth inboundPartialDate;
}
