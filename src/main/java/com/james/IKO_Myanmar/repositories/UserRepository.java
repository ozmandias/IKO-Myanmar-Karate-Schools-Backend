package com.james.IKO_Myanmar.repositories;

import com.james.IKO_Myanmar.models.User;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepository extends ListCrudRepository<User, Long> { }