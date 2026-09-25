package com.james.IKO_Myanmar.dtos;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class ApiResponse<T> {
    int statusCode;
    String description;
    LocalDateTime timestamp;
    T data;

    public static <T> ApiResponse<T> ok(T data, String message) {
        return new ApiResponse<T>(
                200,
                "OK" + message != null || message.isEmpty() == false ? " - " + message : "",
                LocalDateTime.now(),
                data
        );
    }

    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<T>(
            400,
            "ERROR" + message != null || message.isEmpty() == false ? " - " + message : "",
            LocalDateTime.now(),
            null
        );
    }
}