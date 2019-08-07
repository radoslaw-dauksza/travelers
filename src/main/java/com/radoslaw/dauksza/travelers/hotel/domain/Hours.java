package com.radoslaw.dauksza.travelers.hotel.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Data
@Entity(name = "hours")
@NoArgsConstructor
public class Hours {
    @Id
    @GeneratedValue
    @NotNull
    private long id;
    @Column(name = "begin_at")
    private LocalTime from;
    @Column(name = "end_at")
    private LocalTime until;

    public Hours(LocalTime from, LocalTime until) {
        this.from = from;
        this.until = until;
    }
}
