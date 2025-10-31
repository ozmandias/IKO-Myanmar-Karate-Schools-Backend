package com.james.IKO_Myanmar.model;

import com.james.IKO_Myanmar.type.TrainerStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity @Table(name = "trainers")
public class Trainer {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    @Column(nullable = false)
    public String name;
    @Column(nullable = false)
    public int rank_id;
    @Column(nullable = false)
    public int user_id;
    @Column(columnDefinition = "ENUM('InService', 'Retired', 'Resigned', 'Dismissed')", nullable = false) @Enumerated(EnumType.STRING)
    public TrainerStatus status;
    public LocalDate service_start_date;
    public LocalDateTime create_date;
    public LocalDateTime update_date;

    public Trainer(
        int id,
        String name,
        int rank_id,
        int user_id,
        TrainerStatus status,
        LocalDate service_start_date,
        LocalDateTime create_date,
        LocalDateTime update_date
    ) {
        this.id = id;
        this.name = name;
        this.rank_id = rank_id;
        this.user_id = user_id;
        this.status = status;
        this.service_start_date = service_start_date;
        this.create_date = create_date;
        this.update_date = update_date;
    }
}