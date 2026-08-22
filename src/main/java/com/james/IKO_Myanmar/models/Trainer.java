package com.james.IKO_Myanmar.models;

import com.james.IKO_Myanmar.enums.TrainerStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity @Table(name = "trainers")
public class Trainer {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    @Column(nullable = false)
    public String name;
    @Column(name = "rank_id", nullable = false)
    public Integer rankId;
    @Column(name = "user_id", nullable = false)
    public Long userId;
    @Column(columnDefinition = "ENUM('InService', 'Retired', 'Resigned', 'Dismissed')", nullable = false) @Enumerated(EnumType.STRING)
    public TrainerStatus status;
    @Column(name = "service_start_date")
    public LocalDate serviceStartDate;
    @Column(name = "create_date")
    public LocalDateTime createDate;
    @Column(name = "update_date")
    public LocalDateTime updateDate;

    public Trainer(
        Long id,
        String name,
        Integer rankId,
        Long userId,
        TrainerStatus status,
        LocalDate serviceStartDate,
        LocalDateTime createDate,
        LocalDateTime updateDate
    ) {
        this.id = id;
        this.name = name;
        this.rankId = rankId;
        this.userId = userId;
        this.status = status;
        this.serviceStartDate = serviceStartDate;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
}