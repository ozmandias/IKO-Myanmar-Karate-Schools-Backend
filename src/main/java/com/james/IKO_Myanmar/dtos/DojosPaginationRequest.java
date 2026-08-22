package com.james.IKO_Myanmar.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DojosPaginationRequest extends PaginationRequest {
    String name;
    String state;
    String city;
    String township;
    String street;
}