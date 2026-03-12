package com.james.IKO_Myanmar.controllers;

import com.james.IKO_Myanmar.models.Class;
import com.james.IKO_Myanmar.services.ClassService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/*@Controller*/ @RestController
public class ClassController {
    private final ClassService classService;

    public ClassController(ClassService classServiceDependency) {
        this.classService = classServiceDependency;
    }

    @GetMapping("/classes")
    public ResponseEntity getClasses() {
        List<Class> classes = classService.getClasses();

        ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(classes != null ? classes : Collections.emptyList());

        return response;
    }

    @GetMapping("/classes/{id}")
    public ResponseEntity getClass(@PathVariable("id") Long id) {
        Optional<Class> optionalClass = classService.getClass(id);
        Class karateClass = null;
        if(optionalClass.isPresent()) {
            karateClass = optionalClass.get();
        }

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
        boolean deleteSuccess = classService.deleteClass(id);

        ResponseEntity response =
                ResponseEntity.status(200)
                        .body(deleteSuccess ? "delete successful!" : "delete failed!");

        return response;
    }
}