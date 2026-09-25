package com.james.IKO_Myanmar.types;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Builder
public class ApiData<T> {
    public String method;
    public String url;
    public T content;
}