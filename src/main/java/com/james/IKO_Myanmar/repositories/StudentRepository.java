package com.james.IKO_Myanmar.repositories;

import com.james.IKO_Myanmar.models.Student;
import org.springframework.data.repository.ListCrudRepository;

public interface StudentRepository extends ListCrudRepository<Student, Long> { }