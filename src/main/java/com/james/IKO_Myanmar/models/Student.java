package com.james.IKO_Myanmar.models;

import com.james.IKO_Myanmar.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity @Table(name = "students")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false)
    String name;

    @Column(name = "rank_id", nullable = false)
    Integer rankId;

    @Column(name = "user_id", nullable = false)
    Long userId;

    @Column(columnDefinition = "ENUM('Learning', 'Graduated', 'OnLeave', 'Quit', 'Banned')", nullable = false) @Enumerated(EnumType.STRING)
    Status status;

    @Column(name = "join_date")
    LocalDate joinDate;

    @Column(name = "create_date")
    LocalDateTime createDate;

    @Column(name = "update_date")
    LocalDateTime updateDate;

    /*public Student(
        Long id,
        String name,
        Integer rankId,
        Long userId,
        Status status,
        LocalDate joinDate,
        LocalDateTime createDate,
        LocalDateTime updateDate
    ) {
        this.id = id;
        this.name = name;
        this.rankId = rankId;
        this.userId = userId;
        this.status = status;
        this.joinDate = joinDate;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }*/
}