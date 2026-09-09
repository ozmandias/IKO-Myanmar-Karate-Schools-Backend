package com.james.IKO_Myanmar.models;

import com.james.IKO_Myanmar.enums.Gender;
import com.james.IKO_Myanmar.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "fighters")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Fighter {
    @Id
    Long id;

    @Column(name = "user_id", nullable = false)
    Long userId;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    Integer age;

    @Column(nullable = false)
    Gender gender;

    @Column(name="weight_in_kg", nullable = false)
    Integer weightInKg;

    @Column(name="weight_in_lb")
    Integer weightInLb;

    @Column(columnDefinition = "ENUM('Active', 'Inactive', 'Deactivated')", nullable = false)
    Status status;

    @Column(name="register_date")
    LocalDate registerDate;

    @Column(name="create_date")
    LocalDateTime createDate;

    @Column(name="updaet_date")
    LocalDateTime updateDate;
}