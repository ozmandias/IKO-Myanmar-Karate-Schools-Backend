package com.james.IKO_Myanmar.repositories;

import com.james.IKO_Myanmar.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends /*ListCrudRepository<User, Long>*/ JpaRepository<User, Long> {
    User findByEmailContainingIgnoreCase(String email);

    User findByUsernameContainingIgnoreCase(String username);

    /*@Query(
            "SELECT u FROM User u WHERE " +
            "(:username IS NULL OR :username = '' OR u.username = :username) AND " +
            "(:fullName IS NULL OR :fullName = '' OR u.fullName = :fullName) AND" +
            "(:email IS NULL OR :email = '' OR u.email = :email)"
    )
    Page<User> findAllBy(
            @Param("username") String username,
            @Param("fullName") String fullName,
            @Param("email") String email,
            Pageable pageable
    );*/

    @Query(
            "SELECT u FROM User u WHERE " +
            "(:username IS NULL OR :username = '' OR u.username LIKE CONCAT(:username, '%')) AND " +
            "(:fullName IS NULL OR :fullName = '' OR u.fullName LIKE CONCAT(:fullName, '%')) AND " +
            "(:email IS NULL OR :email = '' OR u.email LIKE CONCAT(:email, '%')) AND " +
            "(:phone IS NULL OR :phone = '' OR u.phone LIKE CONCAT(:phone, '%'))"
    )
    Page<User> findAllBy(
            @Param("username") String username,
            @Param("fullName") String fullName,
            @Param("email") String email,
            @Param("phone") String phone,
            Pageable pageable
    );
}