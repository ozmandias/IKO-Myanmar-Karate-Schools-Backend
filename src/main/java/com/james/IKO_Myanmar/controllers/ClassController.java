package com.james.IKO_Myanmar.controllers;

import com.james.IKO_Myanmar.dtos.ApiResponse;
import com.james.IKO_Myanmar.dtos.ClassesPaginationRequest;
import com.james.IKO_Myanmar.models.Class;
import com.james.IKO_Myanmar.services.ClassService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

/*@Controller*/ @RestController
public class ClassController {
    private final ClassService classService;

    public ClassController(ClassService classServiceDependency) {
        this.classService = classServiceDependency;
    }

    @GetMapping("/classes/all")
    public ResponseEntity getClasses() {
        List<Class> classes = classService.getClasses();

        ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(classes != null ? classes : Collections.emptyList());

        return response;
    }

    @GetMapping("/classes")
    public ResponseEntity getClassesPagination(ClassesPaginationRequest classesPaginationRequest) {
        Page<Class> classes = classService.getClassesPagination(classesPaginationRequest);

        ApiResponse apiResponse = new ApiResponse<>(
                0000,
                "",
                LocalDateTime.now(),
                classes
        );

        ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(apiResponse);

        return response;
    }

    @GetMapping("/classes/{id}")
    public ResponseEntity getClass(@PathVariable("id") Long id) {
        Class karateClass = classService.getClass(id);

        ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(karateClass != null ? karateClass : Collections.emptyMap());

        return response;
    }

    @PostMapping("/classes")
    public ResponseEntity postClass(@RequestBody Class classData) {
        Class karateClass = classService.createClass(classData);

        ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(karateClass != null ? karateClass : Collections.emptyMap());

        return response;
    }

    @PutMapping("/classes/{id}")
    public ResponseEntity putClass(@PathVariable("id") Long id, @RequestBody Class classData) {
        Class karateClass = classService.updateClass(id, classData);

        ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(karateClass != null ? karateClass : Collections.emptyMap());

        return response;
    }

    @DeleteMapping("/classes/{id}")
    public ResponseEntity deleteClass(@PathVariable("id") Long id) {
        classService.deleteClass(id);

        /*ResponseEntity response =
                ResponseEntity.status(200)
                        .body(deleteSuccess ? "delete successful!" : "delete failed!");*/

        return new ResponseEntity(HttpStatus.OK);
    }
}