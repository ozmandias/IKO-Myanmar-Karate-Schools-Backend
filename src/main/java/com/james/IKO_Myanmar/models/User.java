package com.james.IKO_Myanmar.models;

import com.james.IKO_Myanmar.enums.Gender;
import com.james.IKO_Myanmar.enums.Status;
import com.james.IKO_Myanmar.enums.Type;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity @Table(name = "users")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class User {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false)
    String username;

    @Column(name = "full_name", nullable = false)
    String fullName;

    @Column(nullable = false)
    String email;

    @Column(nullable = false)
    String password;

    @Column(nullable = true)
    String phone;

    @Column(nullable = false)
    String address;

    @Column(columnDefinition = "ENUM('Male', 'Female') DEFAULT 'Male'", nullable = false) @Enumerated(EnumType.STRING)
    Gender gender;

    @Column(name = "date_of_birth", nullable = true)
    LocalDate dateOfBirth;

    @Column(name = "age", nullable = true)
    Integer age;

    @Column(name = "rank_id", nullable = false)
    Integer rankId;

    @Column(name = "nrc_number")
    String nrcNumber;

    @Column(name = "international_card")
    String internationalCard;

    @Column(name = "user_type", nullable = false) @Enumerated(EnumType.STRING)
    Type userType;

    @Column(name = "profile_type", nullable = false) @Enumerated(EnumType.STRING)
    Type profileType;

    @Column(nullable = false) @Enumerated(EnumType.STRING)
    Status status;

    @Column(name = "create_date")
    LocalDateTime createDate;

    @Column(name = "update_date")
    LocalDateTime updateDate;

    /*public User(
            int id,
            String username,
            String fullName,
            String email,
            String password,
            String phone,
            String address,
            UserGender gender,
            int rankId,
            String nrcNumber,
            String internationalCard,
            UserType userType,
            ProfileType profileType,
            UserStatus status,
            LocalDateTime createDate,
            LocalDateTime updateDate
    ) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.rankId = rankId;
        this.nrcNumber = nrcNumber;
        this.internationalCard = internationalCard;
        this.userType = userType;
        this.profileType = profileType;
        this.status = status;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }*/
}