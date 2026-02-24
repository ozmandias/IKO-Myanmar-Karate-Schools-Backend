package com.james.IKO_Myanmar.models;

import com.james.IKO_Myanmar.enums.DojoStatus;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity @Table(name = "dojos") @NoArgsConstructor
public class Dojo {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    @Column(nullable = false)
    public String name;
    @Column(nullable = false)
    public String address;
    @Column(columnDefinition = "ENUM('Open', 'Closed', 'Repairing', 'Defunct')", nullable = false) @Enumerated(EnumType.STRING)
    public DojoStatus status;
    public LocalDate startDate;
    public LocalDateTime createDate;
    public LocalDateTime updateDate;

    public Dojo(
        int id,
        String name,
        String address,
        DojoStatus status,
        LocalDate startDate,
        LocalDateTime createDate,
        LocalDateTime updateDate
    ) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.status = status;
        this.startDate = startDate;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
}