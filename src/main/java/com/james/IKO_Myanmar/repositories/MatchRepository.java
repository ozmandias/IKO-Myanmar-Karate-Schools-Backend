package com.james.IKO_Myanmar.repositories;

import com.james.IKO_Myanmar.models.Match;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface MatchRepository extends JpaRepository<Match, Long> {
    @Query(
        "SELECT m FROM Match m WHERE " +
        "(m.tournamentId IS NULL OR m.tournamentId = :tournamentId) AND " +
        "(m.name IS NULL OR m.name = '' OR m.name LIKE CONCAT('%', :name, '%')) AND " +
        "(m.notes IS NULL OR m.notes = '' OR m.notes LIKE CONCAT('%', :notes, '%')) AND " +
        "(m.rounds IS NULL OR m.rounds = :rounds) AND " +
        "(m.dateTime IS NULL OR m.dateTime = :dateTime)"
    )
    Page<Match> findAllBy(
            @Param("tournamentId") Long tournamentId,
            @Param("name") String name,
            @Param("notes") String notes,
            @Param("rounds") Integer rounds,
            @Param("dateTime") LocalDateTime dateTime,
            Pageable pageable
    );
}