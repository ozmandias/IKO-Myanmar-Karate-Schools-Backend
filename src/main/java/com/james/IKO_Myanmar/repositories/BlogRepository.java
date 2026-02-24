package com.james.IKO_Myanmar.repositories;

import com.james.IKO_Myanmar.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> /*ListCrudRepository<Blog, Long>*/ { }