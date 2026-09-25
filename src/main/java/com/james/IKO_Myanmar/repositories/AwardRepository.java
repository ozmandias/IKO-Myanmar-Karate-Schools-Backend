package com.james.IKO_Myanmar.repositories;

import com.james.IKO_Myanmar.models.Award;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface AwardRepository extends JpaRepository<Award, Long> {
    @Query(
            "SELECT a FROM Award a WHERE " +
            "(a.name IS NULL OR a.name = '' OR LOWER(a.name) LIKE CONCAT('%', :name, '%')) AND " +
            "(a.awardDate IS NULL OR a.awardDate = :awardDate)"
    )
    Page<Award> findAllBy(
            @Param("name") String name,
            @Param("awardDate") LocalDate awardDate,
            Pageable pageable
    );
}