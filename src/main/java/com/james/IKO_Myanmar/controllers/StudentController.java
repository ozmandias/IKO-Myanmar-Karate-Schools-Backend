package com.james.IKO_Myanmar.controllers;

import com.james.IKO_Myanmar.models.Student;
import com.james.IKO_Myanmar.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/*@Controller*/ @RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentServiceDependency) {
        this.studentService = studentServiceDependency;
    }

    @GetMapping("/students")
    public ResponseEntity getStudents() {
        List<Student> students = studentService.getStudents();

        ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(students != null ? students : Collections.emptyList());

        return response;
    }

    @GetMapping("/students/{id}")
    public ResponseEntity getStudent(@PathVariable("id") Long id) {
        Student student = studentService.getStudent(id);

        ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(student != null ? student : Collections.emptyMap());

        return response;
    }

    @PostMapping("/students")
    public ResponseEntity postStudent(@RequestBody Student studentData) {
        Student student = studentService.createStudent(studentData);

        ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(student != null ? student : Collections.emptyMap());

        return response;
    }

    @PutMapping("/students/{id}")
    public ResponseEntity putStudent(@PathVariable("id") Long id, @RequestBody Student studentData) {
        Student student = studentService.updateStudent(id, studentData);

        ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(student != null ? student : Collections.emptyMap());

        return response;
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);

        /*ResponseEntity response =
                ResponseEntity.status(200)
                        .body(deleteSuccess ? "delete successful!" : "delete failed!");*/

        return new ResponseEntity(HttpStatus.OK);
    }
}