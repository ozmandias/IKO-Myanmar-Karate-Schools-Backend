package com.james.IKO_Myanmar.model;

import com.james.IKO_Myanmar.converter.DayOfWeekSetConverter;
import com.james.IKO_Myanmar.type.ClassStatus;
import com.james.IKO_Myanmar.type.DayOfWeek;
import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

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
    public int dojo_id;
    @Column(nullable = false)
    public int training_id;
    @Column(nullable = false)
    public LocalTime starting_time;
    @Column(nullable = false)
    public LocalTime closing_time;
    @Column(columnDefinition = "SET('Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday')") @Convert(converter = DayOfWeekSetConverter.class)
    public Set<DayOfWeek> opening_days;
    @Column(columnDefinition = "ENUM('Started', 'Finished', 'Cancelled', 'Discontinued')", nullable = false) @Enumerated(EnumType.STRING)
    public ClassStatus status;
    public LocalDate start_date;
    public LocalDateTime create_date;
    public LocalDateTime update_date;

    public Class(
        int id,
        String name,
        int dojo_id,
        int training_id,
        LocalTime starting_time,
        LocalTime closing_time,
        Set<DayOfWeek> opening_days,
        ClassStatus status,
        LocalDate start_date,
        LocalDateTime create_date,
        LocalDateTime update_date
    ) {
        this.id = id;
        this.name = name;
        this.dojo_id = dojo_id;
        this.training_id = training_id;
        this.starting_time = starting_time;
        this.closing_time = closing_time;
        this.opening_days = opening_days;
        this.status = status;
        this.start_date = start_date;
        this.create_date = create_date;
        this.update_date = update_date;
    }
}