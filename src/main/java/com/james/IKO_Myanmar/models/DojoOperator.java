package com.james.IKO_Myanmar.models;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity @Table(name = "dojo_operators") @NoArgsConstructor
public class DojoOperator {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    @Column(name = "user_id", nullable = false)
    public Long userId;
    @Column(name = "dojo_id", nullable = false)
    public Long dojoId;
    @Column(name = "start_date")
    public LocalDate startDate;
    @Column(name = "create_date")
    public LocalDateTime createDate;
    @Column(name = "update_date")
    public LocalDateTime updateDate;

    public DojoOperator(
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
    }
}