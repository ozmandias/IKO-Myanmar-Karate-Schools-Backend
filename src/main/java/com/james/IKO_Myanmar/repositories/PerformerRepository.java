package com.james.IKO_Myanmar.repositories;

import com.james.IKO_Myanmar.enums.Gender;
import com.james.IKO_Myanmar.models.Performer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Optional;

public interface PerformerRepository extends JpaRepository<Performer, Long> {
    Optional<Performer> findByUserId(Long userId);

    @Query(
            "SELECT p FROM Performer p WHERE " +
            "(p.name IS NULL OR p.name = '' OR LOWER(p.name) LIKE CONCAT('%', :name, '%')) AND " +
            "(p.age IS NULL OR p.age = :age) AND " +
            "(p.gender IS NULL OR p.gender = :gender) AND " +
            "(p.weightInKg IS NULL OR p.weightInKg = :weightInKg) AND " +
            "(p.weightInLb IS NULL OR p.weightInLb = :weighInLb) AND " +
            "(p.registerDate IS NULL OR p.registerDate = :registerDate) "
    )
    Page<Performer> findAllBy(
            @Param("name") String name,
            @Param("age") Integer age,
            @Param("gender") Gender gender,
            @Param("weightInKg") Integer weightInKg,
            @Param("weightInLb") Integer weightInLb,
            @Param("registerDate") LocalDate registerDate,
            Pageable pageable
    );
}