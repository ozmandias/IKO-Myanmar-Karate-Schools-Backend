package com.james.IKO_Myanmar.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class MatchesPaginationRequest extends PaginationRequest {
    Long tournamentId;
    String name;
    String notes;
    Integer rounds;
    LocalDateTime dateTime;
}