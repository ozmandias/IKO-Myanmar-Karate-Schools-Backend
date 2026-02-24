package com.james.IKO_Myanmar.models;

import com.james.IKO_Myanmar.enums.ProfileType;
import com.james.IKO_Myanmar.enums.UserGender;
import com.james.IKO_Myanmar.enums.UserStatus;
import com.james.IKO_Myanmar.enums.UserType;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity @Table(name = "users") @NoArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    @Column(nullable = false)
    public String username;
    @Column(name = "full_name", nullable = false)
    public String fullName;
    @Column(nullable = false)
    public String email;
    @Column(nullable = false)
    public String password;
    public String phone;
    @Column(nullable = false)
    public String address;
    @Column(columnDefinition = "ENUM('Male', 'Female') DEFAULT 'Male'", nullable = false) @Enumerated(EnumType.STRING)
    public UserGender gender;
    @Column(name = "rank_id", nullable = false)
    public int rankId;
    @Column(name = "nrc_number")
    public String nrcNumber;
    @Column(name = "international_card")
    public String internationalCard;
    @Column(name = "user_type", nullable = false) @Enumerated(EnumType.STRING)
    public UserType userType;
    @Column(name = "profile_type", nullable = false) @Enumerated(EnumType.STRING)
    public ProfileType profileType;
    @Column(nullable = false) @Enumerated(EnumType.STRING)
    public UserStatus status;
    @Column(name = "create_date")
    public LocalDateTime createDate;
    @Column(name = "update_date")
    public LocalDateTime updateDate;

    public User(
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
    }
}