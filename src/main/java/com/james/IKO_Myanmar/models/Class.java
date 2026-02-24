package com.james.IKO_Myanmar.models;

import com.james.IKO_Myanmar.converters.DayOfWeekSetConverter;
import com.james.IKO_Myanmar.enums.ClassStatus;
import com.james.IKO_Myanmar.enums.DayOfWeek;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

@Entity @Table(name = "classes")
public class Class {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    @Column(nullable = false)
    public String name;
    @Column(nullable = false)
    public int dojoId;
    @Column(nullable = false)
    public int trainingId;
    @Column(nullable = false)
    public LocalTime startingTime;
    @Column(nullable = false)
    public LocalTime closingTime;
    @Column(columnDefinition = "SET('Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday')") @Convert(converter = DayOfWeekSetConverter.class)
    public Set<DayOfWeek> openingDays;
    @Column(columnDefinition = "ENUM('Started', 'Finished', 'Cancelled', 'Discontinued')", nullable = false) @Enumerated(EnumType.STRING)
    public ClassStatus status;
    public LocalDate startDate;
    public LocalDateTime createDate;
    public LocalDateTime updateDate;

    public Class(
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
        this.startDate = startDate;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
}