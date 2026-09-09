package com.james.IKO_Myanmar.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity @Table(name = "dojo_operators")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class DojoOperator {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "user_id", nullable = false)
    Long userId;

    @Column(name = "dojo_id", nullable = false)
    Long dojoId;

    @Column(name = "start_date")
    LocalDate startDate;

    @Column(name = "create_date")
    LocalDateTime createDate;

    @Column(name = "update_date")
    LocalDateTime updateDate;

    /*public DojoOperator(
        Long id,
        Long userId,
        Long dojoId,
        LocalDate startDate,
        LocalDateTime createDate,
        LocalDateTime updateDate
    ) {
        this.id = id;
        this.userId = userId;
        this.dojoId = dojoId;
        this.startDate = startDate;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }*/
}