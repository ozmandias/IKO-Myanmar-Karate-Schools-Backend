package com.james.IKO_Myanmar.models;

import com.james.IKO_Myanmar.enums.TrainingStatus;
import jakarta.persistence.*;

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
    @Column(name = "create_date")
    public LocalDateTime createDate;
    @Column(name = "update_date")
    public LocalDateTime updateDate;

    public Training(
        int id,
        String notes,
        TrainingStatus status,
        LocalDate date,
        LocalDateTime createDate,
        LocalDateTime updateDate
    ) {
        this.id = id;
        this.notes = notes;
        this.status = status;
        this.date = date;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
}