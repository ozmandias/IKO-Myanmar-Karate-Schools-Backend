package com.james.IKO_Myanmar.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class AwardPaginationRequest extends PaginationRequest{
    String name;
    LocalDate awardDate;
}