package com.james.IKO_Myanmar.types;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@NoArgsConstructor
@Builder
public class PaginationData<T> {
    List<T> content;
    public int page;
    public int size;
    public int totalPages;
    public long totalElements;
    public boolean last;

    public PaginationData(
            List<T> content,
            int page,
            int size,
            int totalPages,
            long totalElements,
            boolean last
    ) {
        this.content = content;
        this.page = page;
        this.size = size;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.last = last;
    }

    public static <T> PaginationData<T> of(Page<T> page) {
        return new PaginationData<T>(page.getContent(), page.getNumber(), page.getSize(), page.getTotalPages(), page.getTotalElements(), page.isLast());
    }
}