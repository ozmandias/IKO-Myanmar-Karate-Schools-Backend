package com.james.IKO_Myanmar.repositories;

import com.james.IKO_Myanmar.models.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface StudentRepository extends ListCrudRepository<Student, Long> {
    @Query(
            "SELECT s FROM Student s WHERE " +
            "(s.name IS NULL OR s.name = '' OR LOWER(s.name) LIKE CONCAT('%', LOWER(:name), '%')) AND " +
            "(s.rankId IS NULL OR s.rankId = :rankId) AND " +
            "(s.joinDate IS NULL OR s.joinDate = :joinDate) "
    )
    Page<Student> findAllBy(
            @Param("name") String name,
            @Param("rankId") Integer rankId,
            @Param("joinDate") LocalDate joinDate,
            Pageable pageable
    );
}