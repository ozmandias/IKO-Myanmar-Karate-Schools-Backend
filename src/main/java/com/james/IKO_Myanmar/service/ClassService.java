package com.james.IKO_Myanmar.service;

import com.james.IKO_Myanmar.model.Class;
import com.james.IKO_Myanmar.repository.ClassRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ClassService {
    private final ClassRepository classRepository;

    public ClassService(ClassRepository classRepositoryDependency) {
        this.classRepository = classRepositoryDependency;
    }

    public Class createClass(Class classData) {
        classData.create_date = LocalDateTime.now();
        return classRepository.save(classData);
    }

    public List<Class> getClasses() {
        return classRepository.findAll();
    }

    public Optional<Class> getClass(Long id) {
        return classRepository.findById(id);
    }

    public Class updateClass(Long id, Class classData) {
        Optional<Class> optionalClass = getClass(id);
        Class karateClass = null;
        if(optionalClass.isPresent()) {
            karateClass = optionalClass.get();
            classData.id = karateClass.id;
            classData.create_date = karateClass.create_date;
            classData.update_date = LocalDateTime.now();
            karateClass = classRepository.save(classData);
        }
        return karateClass;
    }

    public boolean deleteClass(Long id) {
        boolean deleteStatus = false;
        Optional<Class> optionalClass = getClass(id);
        Class karateClass = null;
        if(optionalClass.isPresent()) {
            karateClass = optionalClass.get();
            classRepository.delete(karateClass);
            deleteStatus = true;
        }
        return  deleteStatus;
    }
}
