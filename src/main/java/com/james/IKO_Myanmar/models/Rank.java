package com.james.IKO_Myanmar.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity @Table(name = "ranks")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Rank {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column(nullable = false)
    String title;

    @Column(name = "create_date")
    LocalDateTime createDate;

    @Column(name = "update_date")
    LocalDateTime updateDate;

    /*public Rank(Integer id, String title) {
        this.id = id;
        this.title = title;
    }*/
}