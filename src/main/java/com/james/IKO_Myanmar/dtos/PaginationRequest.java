package com.james.IKO_Myanmar.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PaginationRequest {
    Integer page;
    Integer size;
}