package com.james.IKO_Myanmar.repositories;

import com.james.IKO_Myanmar.models.Trainer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface TrainerRepository extends ListCrudRepository<Trainer, Long> {
    @Query(
            "SELECT t FROM Trainer t WHERE " +
            "(t.name IS NULL OR t.name = '' OR LOWER(t.name) LIKE CONCAT('%', LOWER(:name), '%')) AND " +
            "(t.rankId IS NULL OR t.rankId = :rankId) AND " +
            "(t.serviceStartDate IS NULL OR t.serviceStartDate = :serviceStartDate)"
    )
    Page<Trainer> findAllBy(
            @Param("name") String name,
            @Param("rankId") Integer rankId,
            @Param("serviceStartDate") LocalDate serviceStartDate,
            Pageable pageable
    );
}