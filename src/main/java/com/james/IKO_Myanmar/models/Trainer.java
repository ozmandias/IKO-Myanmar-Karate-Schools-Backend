package com.james.IKO_Myanmar.models;

import com.james.IKO_Myanmar.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity @Table(name = "trainers")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Trainer {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false)
    String name;

    @Column(name = "rank_id", nullable = false)
    Integer rankId;

    @Column(name = "user_id", nullable = false)
    Long userId;

    @Column(columnDefinition = "ENUM('InService', 'Retired', 'Resigned', 'Dismissed')", nullable = false) @Enumerated(EnumType.STRING)
    Status status;

    @Column(name = "service_start_date")
    LocalDate serviceStartDate;

    @Column(name = "create_date")
    LocalDateTime createDate;

    @Column(name = "update_date")
    LocalDateTime updateDate;

    /*public Trainer(
        Long id,
        String name,
        Integer rankId,
        Long userId,
        Status status,
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
    }*/
}