package com.james.IKO_Myanmar.dtos;

import com.james.IKO_Myanmar.enums.ClassStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassesPaginationRequest extends PaginationRequest {
    String name;
    Long dojoId;
    ClassStatus status;
}