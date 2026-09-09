package com.james.IKO_Myanmar.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class DojosPaginationRequest extends PaginationRequest {
    String name;
    String state;
    String city;
    String township;
    String street;
}