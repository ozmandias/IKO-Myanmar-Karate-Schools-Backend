package com.james.IKO_Myanmar.models;

import com.james.IKO_Myanmar.enums.DojoStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity @Table(name = "dojos")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Dojo {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String address;

    String state;

    String city;

    String township;

    String street;

    @Column(columnDefinition = "ENUM('Open', 'Closed', 'Repairing', 'Defunct')", nullable = false) @Enumerated(EnumType.STRING)
    DojoStatus status;

    @Column(name = "start_date")
    LocalDate startDate;

    @Column(name = "create_date")
    LocalDateTime createDate;

    @Column(name = "update_date")
    LocalDateTime updateDate;

    /*public Dojo(
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
    }*/
}