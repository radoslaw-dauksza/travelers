package com.radoslaw.dauksza.travelers.flight.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Currency;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Quote {
    @Id
    @GeneratedValue
    @NotNull
    private long id;
    @NotNull
    private double minPrice;
    @NotNull
    private boolean direct;
    @NotNull
    @OneToOne
    @JoinColumn
    private Connection outboundConnection;
    @OneToOne
    @JoinColumn
    private Connection inboundConnection;
    @NotNull
    private LocalDateTime quoteDateTime;
    @NotNull
    private Currency currency;

    public Quote(@NotNull double minPrice,
          @NotNull boolean direct,
          @NotNull Connection outboundConnection,
          Connection inboundConnection,
          @NotNull LocalDateTime quoteDateTime,
          @NotNull Currency currency) {
        this.minPrice = minPrice;
        this.direct = direct;
        this.outboundConnection = outboundConnection;
        this.inboundConnection = inboundConnection;
        this.quoteDateTime = quoteDateTime;
        this.currency = currency;
    }
}
