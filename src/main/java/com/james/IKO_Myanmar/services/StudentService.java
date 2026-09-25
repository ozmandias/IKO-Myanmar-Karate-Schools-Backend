package com.james.IKO_Myanmar.services;

import com.james.IKO_Myanmar.dtos.StudentsPaginationRequest;
import com.james.IKO_Myanmar.models.Student;
import com.james.IKO_Myanmar.repositories.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        studentData.setCreateDate(LocalDateTime.now());
        return studentRepository.save(studentData);
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Page<Student> getStudentsPagination(StudentsPaginationRequest studentsPaginationRequest) {
        Pageable pageable = PageRequest.of(studentsPaginationRequest.getPage(), studentsPaginationRequest.getSize());
        Page<Student> studentsPagination = studentRepository.findAllBy(studentsPaginationRequest.getName(), studentsPaginationRequest.getRankId(), studentsPaginationRequest.getJoinDate(), pageable);
        return studentsPagination;
    }

    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElseThrow();
    }

    public Student updateStudent(Long id, Student studentData) {
        Student student = getStudent(id);
        studentData.setId(student.getId());
        studentData.setCreateDate(student.getCreateDate());
        studentData.setUpdateDate(LocalDateTime.now());
        student = studentRepository.save(studentData);
        return student;
    }

    public void deleteStudent(Long id) {
        Student student = getStudent(id);
        studentRepository.delete(student);
    }
}