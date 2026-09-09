package com.james.IKO_Myanmar.models;

import com.james.IKO_Myanmar.enums.Status;
import com.james.IKO_Myanmar.enums.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tournaments")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Tournament {
    @Id
    Long id;

    @Column(nullable = false)
    String name;

    @Column()
    String description;

    @Column(columnDefinition = "ENUM('Fighting', 'Dancing')", nullable = false) @Enumerated(EnumType.STRING)
    Type type;

    @Column(columnDefinition = "ENUM('Started', 'Upcoming', 'Ongoing', 'Ended', 'Cancelled', 'Discontinued')", nullable = false) @Enumerated(EnumType.STRING)
    Status status;

    @Column()
    LocalDate date;

    @Column(name="create_date")
    LocalDateTime createDate;

    @Column(name="update_date")
    LocalDateTime updateDate;
}