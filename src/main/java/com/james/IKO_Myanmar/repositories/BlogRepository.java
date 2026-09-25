package com.james.IKO_Myanmar.repositories;

import com.james.IKO_Myanmar.models.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface BlogRepository extends JpaRepository<Blog, Long> /*ListCrudRepository<Blog, Long>*/ {
    @Query(
            "SELECT b FROM Blog b WHERE " +
            "(b.title IS NULL OR b.title = '' OR LOWER(b.title) LIKE CONCAT('%', LOWER(:title) , '%')) AND " +
            "(b.text IS NULL OR b.text = '' OR LOWER(b.text) LIKE CONCAT('%', LOWER(:text) , '%')) AND " +
            "(b.publishDate IS NULL OR b.publishDate = :publishDate) "
    )
    Page<Blog> findAllBy(
            @Param("title") String title,
            @Param("text") String text,
            @Param("publishDate") LocalDate publishDate,
            Pageable pageable
    );
}