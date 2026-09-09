package com.james.IKO_Myanmar.models;

import com.james.IKO_Myanmar.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "matches")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Match {
    @Id
    Long id;

    @Column(nullable = false)
    Long tournamentId;

    @Column(nullable = false)
    String name;

    @Column()
    String notes;

    @Column()
    Integer rounds;

    @Column(columnDefinition = "ENUM('Started', 'Upcoming', 'Ongoing', 'Ended', 'Cancelled', 'Discontinued')", nullable = false) @Enumerated(EnumType.STRING)
    Status status;

    @Column(name="date_time")
    LocalDateTime dateTime;

    @Column(name="create_date")
    LocalDateTime createDate;

    @Column(name="update_date")
    LocalDateTime updateDate;
}