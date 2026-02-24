package com.james.IKO_Myanmar.dtos;

public class ApiResponse<T> {
    public String code;
    public String description;
    public String timestamp;
    public T data;
}