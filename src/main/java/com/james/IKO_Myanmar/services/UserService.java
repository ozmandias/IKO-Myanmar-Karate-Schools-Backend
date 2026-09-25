package com.james.IKO_Myanmar.services;

import com.james.IKO_Myanmar.dtos.UsersPaginationRequest;
import com.james.IKO_Myanmar.exceptions.NotFoundException;
import com.james.IKO_Myanmar.repositories.UserSQLRepository;
import com.james.IKO_Myanmar.models.User;
import com.james.IKO_Myanmar.repositories.UserRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
    private final UserSQLRepository userSQLRepository;
    private final UserRepository userRepository;

    public UserService(UserSQLRepository userSQLRepositoryDependency, UserRepository userRepositoryDependency) {
        this.userSQLRepository = userSQLRepositoryDependency;
        this.userRepository = userRepositoryDependency;
    }

    @CachePut(value = "user", key = "#result.id")
    @CacheEvict(value = "users", allEntries = true)
    public User createUser(User userData) {
        // return userSQLRepository.create(userData);
        userData.setCreateDate(LocalDateTime.now());
        return userRepository.save(userData);
    }

    @Cacheable(value = "users")
    public List<User> getUsers() {
        // return userSQLRepository.getAll();
        return userRepository.findAll();
    }

    @Cacheable(value = "users", key = "{#usersPaginationRequest.page, #usersPaginationRequest.size, #usersPaginationRequest.username, #usersPaginationRequest.fullName, #usersPaginationRequest.email, #usersPaginationRequest.phone}")
    public Page<User> getUsersPagination(UsersPaginationRequest usersPaginationRequest) {
        Pageable pageable = PageRequest.of(usersPaginationRequest.getPage(), usersPaginationRequest.getSize(), Sort.by("id").descending());
        Page<User> usersPagination = userRepository.findAllBy(
                usersPaginationRequest.getUsername(),
                usersPaginationRequest.getFullName(),
                usersPaginationRequest.getEmail(),
                usersPaginationRequest.getPhone(),
                pageable
        ) /*userRepository.findAll(pageable)*/;
        return usersPagination;
    }

    @Cacheable(value = "user", key = "#id")
    public User getUser(Long id) {
        // return userSQLRepository.getById(id);
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User with id: " + id + " not found!"));
    }

    @CachePut(value = "user", key = "#id")
    @CacheEvict(value = "users", allEntries = true)
    public User updateUser(Long id, User userData) {
        // return userSQLRepository.update(id, userData);
        User user = getUser(id);
        userData.setId(user.getId());
        userData.setCreateDate(user.getCreateDate());
        userData.setUpdateDate(LocalDateTime.now());
        user = userRepository.save(userData);
        return user;
    }

    @CacheEvict(value = "user", key = "#id")
    public void deleteUser(Long id) {
        // return userSQLRepository.delete(id);
        User user = getUser(id);
        userRepository.delete(user);
    }
}