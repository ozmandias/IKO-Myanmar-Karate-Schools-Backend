package com.james.IKO_Myanmar.repositories;

import com.james.IKO_Myanmar.enums.ClassStatus;
import com.james.IKO_Myanmar.models.Class;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface ClassRepository extends ListCrudRepository<Class, Long> {
    @Query(
            "SELECT c FROM Class c WHERE " +
            "(:name IS NULL OR :name = '' OR c.name LIKE CONCAT(:name, '%')) AND " +
            "(:dojoId IS NULL OR c.dojoId = :dojoId) AND " +
            "(:status IS NULL OR :status = '' OR c.status = :status)"
    )
    Page<Class> findAllBy(
            @Param("name") String name,
            @Param("dojoId") Long dojoId,
            @Param("status")ClassStatus status,
            Pageable pageable
    );
}