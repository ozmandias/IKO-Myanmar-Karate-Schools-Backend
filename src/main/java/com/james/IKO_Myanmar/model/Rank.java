package com.james.IKO_Myanmar.model;

import jakarta.persistence.*;

@Entity @Table(name = "ranks")
public class Rank {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    @Column(nullable = false)
    public String title;

    public Rank(int id, String title) {
        this.id = id;
        this.title = title;
    }
}