package com.james.IKO_Myanmar.services;

import com.james.IKO_Myanmar.dtos.ClassesPaginationRequest;
import com.james.IKO_Myanmar.exceptions.NotFoundException;
import com.james.IKO_Myanmar.models.Class;
import com.james.IKO_Myanmar.repositories.ClassRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClassService {
    private final ClassRepository classRepository;

    public ClassService(ClassRepository classRepositoryDependency) {
        this.classRepository = classRepositoryDependency;
    }

    public Class createClass(Class classData) {
        classData.setCreateDate(LocalDateTime.now());
        return classRepository.save(classData);
    }

    public List<Class> getClasses() {
        return classRepository.findAll();
    }

    public Page<Class> getClassesPagination(ClassesPaginationRequest classesPaginationRequest) {
        Pageable pageable = PageRequest.of(classesPaginationRequest.getPage(), classesPaginationRequest.getSize(), Sort.by("id").descending());
        Page<Class> classesPagination = classRepository.findAllBy(
            classesPaginationRequest.getName(),
            classesPaginationRequest.getDojoId(),
            classesPaginationRequest.getStatus(),
            pageable
        );
        return classesPagination;
    }

    public Class getClass(Long id) {
        return classRepository.findById(id).orElseThrow(() -> new NotFoundException("Class with id: " + id + "not found!"));
    }

    public Class updateClass(Long id, Class classData) {
        Class karateClass = getClass(id);
        classData.setId(karateClass.getId());
        classData.setCreateDate(karateClass.getCreateDate());
        classData.setUpdateDate(LocalDateTime.now());
        karateClass = classRepository.save(classData);
        return karateClass;
    }

    public void deleteClass(Long id) {
        Class karateClass = getClass(id);
        classRepository.delete(karateClass);
    }
}
