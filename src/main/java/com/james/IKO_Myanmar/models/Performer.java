package com.james.IKO_Myanmar.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="performers")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Performer {
    @Id
    Long id;
}