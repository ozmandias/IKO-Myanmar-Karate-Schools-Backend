package com.james.IKO_Myanmar.services;

import com.james.IKO_Myanmar.exceptions.NotFoundException;
import com.james.IKO_Myanmar.models.DojoOperator;
import com.james.IKO_Myanmar.repositories.DojoOperatorRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DojoOperatorService {
    private final DojoOperatorRepository dojoOperatorRepository;

    public DojoOperatorService(DojoOperatorRepository dojoOperatorRepositoryDependency) {
        this.dojoOperatorRepository = dojoOperatorRepositoryDependency;
    }

    public DojoOperator createDojoOperator(DojoOperator dojoOperatorData) {
        dojoOperatorData.setCreateDate(LocalDateTime.now());
        return dojoOperatorRepository.save(dojoOperatorData);
    }

    public List<DojoOperator> getDojoOperators() {
        return dojoOperatorRepository.findAll();
    }

    public DojoOperator getDojoOperator(Long id) {
        return dojoOperatorRepository.findById(id).orElseThrow(() -> new NotFoundException("DojoOperator with id: " + id + " not found!"));
    }

    public DojoOperator updateDojoOperator(Long id, DojoOperator dojoOperatorData) {
        DojoOperator dojoOperator = getDojoOperator(id);
        dojoOperatorData.setId(dojoOperator.getId());
        dojoOperatorData.setCreateDate(dojoOperator.getCreateDate());
        dojoOperatorData.setUpdateDate(LocalDateTime.now());
        dojoOperator = dojoOperatorRepository.save(dojoOperatorData);
        return dojoOperator;
    }

    public void deleteDojoOperator(Long id) {
        DojoOperator dojoOperator = getDojoOperator(id);
        dojoOperatorRepository.delete(dojoOperator);
    }
}