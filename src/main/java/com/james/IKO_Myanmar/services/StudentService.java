package com.james.IKO_Myanmar.services;

import com.james.IKO_Myanmar.models.Student;
import com.james.IKO_Myanmar.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    public Optional<Student> getStudent(Long id) {
        return studentRepository.findById(id);
    }

    public Student updateStudent(Long id, Student studentData) {
        Optional<Student> optionalStudent = getStudent(id);
        Student student = null;
        if(optionalStudent.isPresent()) {
            student = optionalStudent.get();
            studentData.id = student.id;
            studentData.createDate = student.createDate;
            studentData.updateDate = LocalDateTime.now();
            student = studentRepository.save(studentData);
        }
        return student;
    }

    public boolean deleteStudent(Long id) {
        boolean deleteStatus = false;
        Optional<Student> optionalStudent = studentRepository.findById(id);
        Student student = null;
        if(optionalStudent.isPresent()) {
            student = optionalStudent.get();
            studentRepository.delete(student);
            deleteStatus = true;
        }
        return deleteStatus;
    }
}