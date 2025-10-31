package com.james.IKO_Myanmar.model;

import com.james.IKO_Myanmar.type.ProfileType;
import com.james.IKO_Myanmar.type.UserGender;
import com.james.IKO_Myanmar.type.UserStatus;
import com.james.IKO_Myanmar.type.UserType;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity @Table(name = "users") @NoArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    @Column(nullable = false)
    public String username;
    @Column(nullable = false)
    public String full_name;
    @Column(nullable = false)
    public String email;
    @Column(nullable = false)
    public String password;
    public String phone;
    @Column(nullable = false)
    public String address;
    @Column(columnDefinition = "ENUM('Male', 'Female') DEFAULT 'Male'", nullable = false) @Enumerated(EnumType.STRING)
    public UserGender gender;
    @Column(nullable = false)
    public int rank_id;
    public String nrc_number;
    public String international_card;
    @Enumerated(EnumType.STRING) @Column(nullable = false)
    public UserType user_type;
    @Enumerated(EnumType.STRING) @Column(nullable = false)
    public ProfileType profile_type;
    @Enumerated(EnumType.STRING) @Column(nullable = false)
    public UserStatus status;
    public LocalDateTime create_date;
    public LocalDateTime update_date;

    public User(
            int id,
            String username,
            String full_name,
            String email,
            String password,
            String phone,
            String address,
            UserGender gender,
            int rank_id,
            String nrc_number,
            String international_card,
            UserType user_type,
            ProfileType profile_type,
            UserStatus status,
            LocalDateTime create_date,
            LocalDateTime update_date
    ) {
        this.id = id;
        this.username = username;
        this.full_name = full_name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.rank_id = rank_id;
        this.nrc_number = nrc_number;
        this.international_card = international_card;
        this.user_type = user_type;
        this.profile_type = profile_type;
        this.status = status;
        this.create_date = create_date;
        this.update_date = update_date;
    }
}