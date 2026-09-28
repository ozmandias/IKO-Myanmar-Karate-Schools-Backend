package com.james.IKO_Myanmar.repositories;

import com.james.IKO_Myanmar.enums.Gender;
import com.james.IKO_Myanmar.models.Fighter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Optional;

public interface FighterRepository extends JpaRepository<Fighter, Long> {
    Optional<Fighter> findByUserId(Long userId);

    @Query(
        "SELECT f FROM Fighter f WHERE " +
        "(f.name IS NULL OR f.name = '' OR LOWER(f.name) LIKE CONCAT('%', :name, '%')) AND " +
        "(f.age IS NULL OR f.age = :age) AND " +
        "(f.gender IS NULL OR f.gender = :gender) AND " +
        "(f.weightInKg IS NULL OR f.weightInKg = :weightInKg) AND " +
        "(f.weightInLb IS NULL OR f.weightInLb = :weighInLb) AND " +
        "(f.registerDate IS NULL OR f.registerDate = :registerDate) "
    )
    Page<Fighter> findAllBy(
        @Param("name") String name,
        @Param("age") Integer age,
        @Param("gender") Gender gender,
        @Param("weightInKg") Integer weightInKg,
        @Param("weightInLb") Integer weightInLb,
        @Param("registerDate") LocalDate registerDate,
        Pageable pageable
    );
}