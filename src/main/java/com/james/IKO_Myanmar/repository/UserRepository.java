package com.james.IKO_Myanmar.repository;

import com.james.IKO_Myanmar.model.User;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepository extends ListCrudRepository<User, Long> { }