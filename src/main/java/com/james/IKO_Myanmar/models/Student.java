package com.james.IKO_Myanmar.models;

import com.james.IKO_Myanmar.enums.StudentStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity @Table(name = "students")
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    @Column(nullable = false)
    public String name;
    @Column(name = "rank_id", nullable = false)
    public Integer rankId;
    @Column(name = "user_id", nullable = false)
    public Long userId;
    @Column(columnDefinition = "ENUM('Learning', 'Graduated', 'OnLeave', 'Quit', 'Banned')", nullable = false) @Enumerated(EnumType.STRING)
    public StudentStatus status;
    @Column(name = "join_date")
    public LocalDate joinDate;
    @Column(name = "create_date")
    public LocalDateTime createDate;
    @Column(name = "update_date")
    public LocalDateTime updateDate;

    public Student(
        Long id,
        String name,
        Integer rankId,
        Long userId,
        StudentStatus status,
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
    }
}