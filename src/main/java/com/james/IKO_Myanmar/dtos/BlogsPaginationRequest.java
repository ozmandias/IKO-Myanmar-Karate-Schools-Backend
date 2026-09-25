package com.james.IKO_Myanmar.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class BlogsPaginationRequest extends PaginationRequest {
    String title;
    String text;
    LocalDate publishDate;
}