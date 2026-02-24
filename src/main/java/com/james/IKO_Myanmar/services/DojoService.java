package com.james.IKO_Myanmar.services;

import com.james.IKO_Myanmar.models.Dojo;
import com.james.IKO_Myanmar.repositories.DojoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DojoService {
    private final DojoRepository dojoRepository;

    public DojoService(DojoRepository dojoRepositoryDependency) {
        this.dojoRepository = dojoRepositoryDependency;
    }

    public Dojo createDojo(Dojo dojoData) {
        dojoData.createDate = LocalDateTime.now();
        return dojoRepository.save(dojoData);
    }

    public List<Dojo> getDojos() {
        return dojoRepository.findAll();
    }

    public Optional<Dojo> getDojo(Long id) {
        return dojoRepository.findById(id);
    }

    public Dojo updateDojo(Long id, Dojo dojoData) {
        Optional<Dojo> optionalDojo = getDojo(id);
        Dojo dojo = null;
        if(optionalDojo.isPresent()) {
            dojo = optionalDojo.get();
            dojoData.id = dojo.id;
            dojoData.createDate = dojo.createDate;
            dojoData.updateDate = LocalDateTime.now();
            dojo = dojoRepository.save(dojoData);
        }
        return dojo;
    }

    public boolean deleteDojo(Long id) {
        boolean deleteStatus = false;
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        Dojo dojo = null;
        if(optionalDojo.isPresent()) {
            dojo = optionalDojo.get();
            dojoRepository.delete(dojo);
            deleteStatus = true;
        }
        return deleteStatus;
    }
}