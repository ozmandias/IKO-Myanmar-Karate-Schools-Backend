package com.james.IKO_Myanmar.dtos;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApiResponse<T> {
    int statusCode;
    String description;
    LocalDateTime timestamp;
    T data;
}