package com.james.IKO_Myanmar.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class TrainingsPaginationRequest extends PaginationRequest {
    LocalDate date;
}