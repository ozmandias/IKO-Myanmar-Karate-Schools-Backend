package com.james.IKO_Myanmar.repositories;

import com.james.IKO_Myanmar.models.Rank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface RankRepository extends ListCrudRepository<Rank, Integer> {
    @Query(
            "SELECT r FROM Rank r WHERE " +
            "(r.title IS NULL OR r.title = '' OR LOWER(r.title) LIKE CONCAT('%', :title, '%'))"
    )
    Page<Rank> findAllBy(
            @Param("title") String title,
            Pageable pageable
    );
}