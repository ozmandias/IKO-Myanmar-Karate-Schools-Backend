package com.james.IKO_Myanmar.models;

import com.james.IKO_Myanmar.converters.DayOfWeekSetConverter;
import com.james.IKO_Myanmar.enums.DayOfWeek;
import com.james.IKO_Myanmar.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

@Entity @Table(name = "classes")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Class {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false)
    String name;

    @Column(name = "dojo_id", nullable = false)
    Long dojoId;

    @Column(name = "starting_time", nullable = false)
    LocalTime startingTime;

    @Column(name = "closing_time", nullable = false)
    LocalTime closingTime;

    @Column(name = "opening_days", columnDefinition = "SET('Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday')") @Convert(converter = DayOfWeekSetConverter.class)
    Set<DayOfWeek> openingDays;

    @Column(columnDefinition = "ENUM('Started', 'Ended', 'Cancelled', 'Discontinued')", nullable = false) @Enumerated(EnumType.STRING)
    Status status;

    @Column()
    LocalDate date;

    @Column(name = "create_date")
    LocalDateTime createDate;

    @Column(name = "update_date")
    LocalDateTime updateDate;

    /*public Class(
        int id,
        String name,
        int dojoId,
        int trainingId,
        LocalTime startingTime,
        LocalTime closingTime,
        Set<DayOfWeek> openingDays,
        ClassStatus status,
        LocalDate startDate,
        LocalDateTime createDate,
        LocalDateTime updateDate
    ) {
        this.id = id;
        this.name = name;
        this.dojoId = dojoId;
        this.trainingId = trainingId;
        this.startingTime = startingTime;
        this.closingTime = closingTime;
        this.openingDays = openingDays;
        this.status = status;
        this.date = date;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }*/
}