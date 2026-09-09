package com.james.IKO_Myanmar.dtos;

import com.james.IKO_Myanmar.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class TournamentPaginationRequest extends PaginationRequest{
    String name;
    LocalDate date;
    Type type;
}