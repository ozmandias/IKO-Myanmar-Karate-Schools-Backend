package com.james.IKO_Myanmar.services;

import com.james.IKO_Myanmar.models.Class;
import com.james.IKO_Myanmar.repositories.ClassRepository;
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
        classData.createDate = LocalDateTime.now();
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
            classData.createDate = karateClass.createDate;
            classData.updateDate = LocalDateTime.now();
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
