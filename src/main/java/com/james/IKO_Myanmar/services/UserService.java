package com.james.IKO_Myanmar.services;

import com.james.IKO_Myanmar.repositories.UserSQLRepository;
import com.james.IKO_Myanmar.models.User;
import com.james.IKO_Myanmar.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserSQLRepository userSQLRepository;
    private final UserRepository userRepository;

    public UserService(UserSQLRepository userSQLRepositoryDependency, UserRepository userRepositoryDependency) {
        this.userSQLRepository = userSQLRepositoryDependency;
        this.userRepository = userRepositoryDependency;
    }

    public User createUser(User userData) {
        // return userSQLRepository.create(userData);
        userData.createDate = LocalDateTime.now();
        return userRepository.save(userData);
    }

    public List<User> getUsers() {
        // return userSQLRepository.getAll();
        return userRepository.findAll();
    }

    public Optional<User> getUser(Long id) {
        // return userSQLRepository.getById(id);
        return userRepository.findById(id);
    }

    public User updateUser(Long id, User userData) {
        // return userSQLRepository.update(id, userData);
        Optional<User> optionalUser = getUser(id);
        User user = null;
        if(optionalUser.isPresent()) {
            user = optionalUser.get();
            userData.id = user.id;
            userData.createDate = user.createDate;
            userData.updateDate = LocalDateTime.now();
            user = userRepository.save(userData);
        }
        return user;
    }

    public boolean deleteUser(Long id) {
        // return userSQLRepository.delete(id);
        boolean deleteStatus = false;
        Optional<User> optionalUser = getUser(id);
        User user = null;
        if(optionalUser.isPresent()) {
            user = optionalUser.get();
            userRepository.delete(user);
            deleteStatus = true;
        }
        return deleteStatus;
    }
}