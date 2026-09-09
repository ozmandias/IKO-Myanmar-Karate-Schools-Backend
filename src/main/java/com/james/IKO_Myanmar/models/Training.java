package com.james.IKO_Myanmar.models;

import com.james.IKO_Myanmar.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity @Table(name = "trainings")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Training {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column()
    String notes;

    @Column(name = "class_id", nullable = false)
    Long classId;

    @Column(columnDefinition = "ENUM('Ongoing', 'Ended')", nullable = false) @Enumerated(EnumType.STRING)
    Status status;

    @Column()
    LocalDate date;

    @Column(name = "create_date")
    LocalDateTime createDate;

    @Column(name = "update_date")
    LocalDateTime updateDate;

    /*public Training(
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
    }*/
}