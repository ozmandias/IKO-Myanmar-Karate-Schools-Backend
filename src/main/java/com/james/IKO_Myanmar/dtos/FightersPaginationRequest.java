package com.james.IKO_Myanmar.dtos;

import com.james.IKO_Myanmar.enums.Gender;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class FightersPaginationRequest extends PaginationRequest {
    String name;
    Integer age;
    Gender gender;
    Integer weightInKg;
    Integer weightInLb;
    LocalDate registerDate;
}