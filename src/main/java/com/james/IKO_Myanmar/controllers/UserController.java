package com.james.IKO_Myanmar.controllers;

import com.james.IKO_Myanmar.dtos.ApiResponse;
import com.james.IKO_Myanmar.dtos.UsersPaginationRequest;
import com.james.IKO_Myanmar.models.User;
import com.james.IKO_Myanmar.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin /*@Controller*/ @RestController
class UserController {
    private final UserService userService;

    public UserController(UserService userServiceDependency) {
        this.userService = userServiceDependency;
    }

    @GetMapping("/users/all")
    public ResponseEntity<ApiResponse<List<User>>> getUsers() {
        List<User> users = userService.getUsers();

        ApiResponse<List<User>> apiResponse = new ApiResponse(
                HttpStatus.OK.value(),
                "",
                LocalDateTime.now(),
                users
        );

        /*ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(
                                users != null ? users : Collections.emptyList()
                        );*/

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity getUsersPagination(UsersPaginationRequest usersPaginationRequest) {
        Page<User> users = userService.getUsersPagination(usersPaginationRequest);

        ApiResponse<Page<User>> apiResponse = new ApiResponse(
                HttpStatus.OK.value(),
                "",
                LocalDateTime.now(),
                users
        );

        /*ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(users);*/

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<ApiResponse<User>> getUser(@PathVariable("id") Long id) {
        User user = userService.getUser(id);

        ApiResponse<User> apiResponse = new ApiResponse(
                HttpStatus.OK.value(),
                "",
                LocalDateTime.now(),
                user
        );

        /*ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(user != null ? user : Collections.emptyMap());*/

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<ApiResponse<User>> postUser(@RequestBody User userData) {
        User user = userService.createUser(userData);

        ApiResponse<User> apiResponse = new ApiResponse(
                HttpStatus.OK.value(),
                "",
                LocalDateTime.now(),
                user
        );

        /*ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(user != null ? user : Collections.emptyMap());*/

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<ApiResponse<User>> putUser(@PathVariable("id") Long id, @RequestBody User userData) {
        User user = userService.updateUser(id, userData);

        ApiResponse<User> apiResponse = new ApiResponse(
                HttpStatus.OK.value(),
                "",
                LocalDateTime.now(),
                user
        );

        /*ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(user != null ? user : Collections.emptyMap());*/

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<ApiResponse<String>> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);

        ApiResponse apiResponse = new ApiResponse(
                HttpStatus.OK.value(),
                "",
                LocalDateTime.now(),
                "delete successful"
        );

        /*ResponseEntity response =
                ResponseEntity.status(200)
                        .body(deleteSuccess ? "delete successful!" : "delete failed!");*/

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}