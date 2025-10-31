package com.james.IKO_Myanmar.repository;

import com.james.IKO_Myanmar.model.Student;
import org.springframework.data.repository.ListCrudRepository;

public interface StudentRepository extends ListCrudRepository<Student, Long> { }