package com.james.IKO_Myanmar.repositories;

import com.james.IKO_Myanmar.enums.Type;
import com.james.IKO_Myanmar.models.Tournament;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
    @Query(
            "SELECT t FROM Tournament t WHERE " +
            "(:name IS NULL OR :name = '' OR t.name LIKE CONCAT(:name, '%') ) AND " +
            "(:date IS NULL OR t.date = date) AND" +
            "(:type IS NULL OR t.type = :type)"
    )
    Page<Tournament> findAllBy(
            @Param("name") String name,
            @Param("date") LocalDate date,
            @Param("type") Type type,
            Pageable pageable
    );
}