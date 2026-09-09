package com.james.IKO_Myanmar.dtos;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class UsersPaginationRequest extends PaginationRequest {
    String username;
    String fullName;
    String email;
    String phone;
}