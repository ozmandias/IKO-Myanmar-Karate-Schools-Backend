package com.james.IKO_Myanmar.models;

import com.james.IKO_Myanmar.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity @Table(name = "awards")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Award {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String description;

    @ManyToOne @JoinColumn(name = "user_id", nullable = false)
    User awardeeUser;

    @Column(name = "award_date")
    LocalDate awardDate;

    @Column(nullable = false) @Enumerated(EnumType.STRING)
    Status status;

    @Column(name = "create_date")
    LocalDateTime createDate;

    @Column(name = "update_date")
    LocalDateTime updateDate;
}