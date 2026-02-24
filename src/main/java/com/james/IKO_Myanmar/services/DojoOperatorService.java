package com.james.IKO_Myanmar.services;

import com.james.IKO_Myanmar.models.DojoOperator;
import com.james.IKO_Myanmar.repositories.DojoOperatorRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DojoOperatorService {
    private final DojoOperatorRepository dojoOperatorRepository;

    public DojoOperatorService(DojoOperatorRepository dojoOperatorRepositoryDependency) {
        this.dojoOperatorRepository = dojoOperatorRepositoryDependency;
    }

    public DojoOperator createDojoOperator(DojoOperator dojoOperatorData) {
        dojoOperatorData.createDate = LocalDateTime.now();
        return dojoOperatorRepository.save(dojoOperatorData);
    }

    public List<DojoOperator> getDojoOperators() {
        return dojoOperatorRepository.findAll();
    }

    public Optional<DojoOperator> getDojoOperator(Long id) {
        return dojoOperatorRepository.findById(id);
    }

    public DojoOperator updateDojoOperator(Long id, DojoOperator dojoOperatorData) {
        Optional<DojoOperator> optionalDojoOperator = getDojoOperator(id);
        DojoOperator dojoOperator = null;
        if(optionalDojoOperator.isPresent()) {
            dojoOperator = optionalDojoOperator.get();
            dojoOperatorData.id = dojoOperator.id;
            dojoOperatorData.createDate = dojoOperator.createDate;
            dojoOperatorData.updateDate = LocalDateTime.now();
            dojoOperator = dojoOperatorRepository.save(dojoOperatorData);
        }
        return dojoOperator;
    }

    public boolean deleteDojoOperator(Long id) {
        boolean deleteStatus = false;
        Optional<DojoOperator> optionalDojoOperator = getDojoOperator(id);
        DojoOperator dojoOperator = null;
        if(optionalDojoOperator.isPresent()) {
            dojoOperator = optionalDojoOperator.get();
            dojoOperatorRepository.delete(dojoOperator);
            deleteStatus = true;
        }
        return deleteStatus;
    }
}