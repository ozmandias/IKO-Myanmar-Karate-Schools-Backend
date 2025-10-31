package com.james.IKO_Myanmar.model;

import com.james.IKO_Myanmar.type.TrainingStatus;
import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity @Table(name = "trainings")
public class Training {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String notes;
    @Column(columnDefinition = "ENUM('Ongoing', 'Ended')", nullable = false) @Enumerated(EnumType.STRING)
    public TrainingStatus status;
    public LocalDate date;
    public LocalDateTime create_date;
    public LocalDateTime update_date;

    public Training(
        int id,
        String notes,
        TrainingStatus status,
        LocalDate date,
        LocalDateTime create_date,
        LocalDateTime update_date
    ) {
        this.id = id;
        this.notes = notes;
        this.status = status;
        this.date = date;
        this.create_date = create_date;
        this.update_date = update_date;
    }
}