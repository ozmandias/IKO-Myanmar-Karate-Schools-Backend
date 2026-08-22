package com.james.IKO_Myanmar.services;

import com.james.IKO_Myanmar.models.Student;
import com.james.IKO_Myanmar.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepositoryDependency) {
        this.studentRepository = studentRepositoryDependency;
    }

    public Student createStudent(Student studentData) {
        studentData.createDate = LocalDateTime.now();
        return studentRepository.save(studentData);
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public List<Student> getStudentsPagination() {
        return null;
    }

    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElseThrow();
    }

    public Student updateStudent(Long id, Student studentData) {
        Student student = getStudent(id);
        studentData.id = student.id;
        studentData.createDate = student.createDate;
        studentData.updateDate = LocalDateTime.now();
        student = studentRepository.save(studentData);
        return student;
    }

    public void deleteStudent(Long id) {
        Student student = getStudent(id);
        studentRepository.delete(student);
    }
}