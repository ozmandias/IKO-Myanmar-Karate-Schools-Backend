package com.james.IKO_Myanmar.model;

import com.james.IKO_Myanmar.type.StudentStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity @Table(name = "students")
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    @Column(nullable = false)
    public String name;
    @Column(nullable = false)
    public int rank_id;
    @Column(nullable = false)
    public int user_id;
    @Column(columnDefinition = "ENUM('Learning', 'Graduated', 'OnLeave', 'Quitted', 'Banned')", nullable = false) @Enumerated(EnumType.STRING)
    public StudentStatus status;
    public LocalDate join_date;
    public LocalDateTime create_date;
    public LocalDateTime update_date;

    public Student(
        int id,
        String name,
        int rank_id,
        int user_id,
        StudentStatus status,
        LocalDate join_date,
        LocalDateTime create_date,
        LocalDateTime update_date
    ) {
        this.id = id;
        this.name = name;
        this.rank_id = rank_id;
        this.user_id = user_id;
        this.status = status;
        this.join_date = join_date;
        this.create_date = create_date;
        this.update_date = update_date;
    }
}