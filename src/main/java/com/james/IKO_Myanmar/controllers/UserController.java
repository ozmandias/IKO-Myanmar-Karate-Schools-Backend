package com.james.IKO_Myanmar.controllers;

import com.james.IKO_Myanmar.models.User;
import com.james.IKO_Myanmar.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@CrossOrigin @Controller
class UserController {
    private final UserService userService;

    public UserController(UserService userServiceDependency) {
        this.userService = userServiceDependency;
    }

    @GetMapping("/users")
    public ResponseEntity getUsers() {
        List<User> users = userService.getUsers();

        ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(users != null ? users : Collections.emptyList());

        return response;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity getUser(@PathVariable("id") Long id) {
        Optional<User> optionalUser = userService.getUser(id);
        User user = null;
        if(optionalUser.isPresent()) {
            user = optionalUser.get();
        }

        ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(user != null ? user : Collections.emptyMap());

        return response;
    }

    @PostMapping("/users")
    public ResponseEntity postUser(@RequestBody User userData) {
        User user = userService.createUser(userData);

        ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(user != null ? user : Collections.emptyMap());

        return response;
    }

    @PutMapping("/users/{id}")
    public ResponseEntity putUser(@PathVariable("id") Long id, @RequestBody User userData) {
        User user = userService.updateUser(id, userData);

        ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(user != null ? user : Collections.emptyMap());

        return response;
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Long id) {
        boolean deleteSuccess = userService.deleteUser(id);

        ResponseEntity response =
                ResponseEntity.status(200)
                        .body(deleteSuccess ? "delete successful!" : "delete failed!");

        return response;
    }
}