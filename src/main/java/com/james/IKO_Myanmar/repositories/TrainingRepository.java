package com.james.IKO_Myanmar.repositories;

import com.james.IKO_Myanmar.models.Training;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface TrainingRepository extends ListCrudRepository<Training, Long> {
    @Query(
            "SELECT t FROM Training t WHERE " +
            "(:date IS NULL OR t.date = :date)"
    )
    Page<Training> findAllBy(
            @Param("date") LocalDate date,
            Pageable pageable
    );
}