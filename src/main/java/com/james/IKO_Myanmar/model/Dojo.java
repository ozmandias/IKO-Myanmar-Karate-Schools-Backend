package com.james.IKO_Myanmar.model;

import com.james.IKO_Myanmar.type.DojoStatus;
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
    public LocalDate start_date;
    public LocalDateTime create_date;
    public LocalDateTime update_date;

    public Dojo(
        int id,
        String name,
        String address,
        DojoStatus status,
        LocalDate start_date,
        LocalDateTime create_date,
        LocalDateTime update_date
    ) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.status = status;
        this.start_date = start_date;
        this.create_date = create_date;
        this.update_date = update_date;
    }
}