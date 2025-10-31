package com.james.IKO_Myanmar.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity @Table(name = "dojo_operators") @NoArgsConstructor
public class DojoOperator {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    @Column(nullable = false)
    public int user_id;
    @Column(nullable = false)
    public int dojo_id;
    public LocalDate startDate;
    public LocalDateTime createDate;
    public LocalDateTime updateDate;

    public DojoOperator(
        int id,
        int user_id,
        int dojo_id,
        LocalDate startDate,
        LocalDateTime createDate,
        LocalDateTime updateDate
    ) {
        this.id = id;
        this.user_id = user_id;
        this.dojo_id = dojo_id;
        this.startDate = startDate;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
}