package com.james.IKO_Myanmar.services;

import com.james.IKO_Myanmar.dtos.DojosPaginationRequest;
import com.james.IKO_Myanmar.exceptions.NotFoundException;
import com.james.IKO_Myanmar.models.Dojo;
import com.james.IKO_Myanmar.repositories.DojoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DojoService {
    private final DojoRepository dojoRepository;

    public DojoService(DojoRepository dojoRepositoryDependency) {
        this.dojoRepository = dojoRepositoryDependency;
    }

    public Dojo createDojo(Dojo dojoData) {
        dojoData.setCreateDate(LocalDateTime.now());
        return dojoRepository.save(dojoData);
    }

    public List<Dojo> getDojos() {
        return dojoRepository.findAll();
    }

    public Page<Dojo> getDojosPagination(DojosPaginationRequest dojosPaginationRequest) {
        Pageable pageable = PageRequest.of(dojosPaginationRequest.getPage(), dojosPaginationRequest.getSize(), Sort.by("id").descending());
        Page<Dojo> dojosPagination = dojoRepository.findAllBy(
                dojosPaginationRequest.getName(),
                dojosPaginationRequest.getState(),
                dojosPaginationRequest.getCity(),
                dojosPaginationRequest.getTownship(),
                dojosPaginationRequest.getStreet(),
                pageable
        );
        return dojosPagination;
    }

    public Dojo getDojo(Long id) {
        return dojoRepository.findById(id).orElseThrow(() -> new NotFoundException("Dojo with id: " + id + "not found!"));
    }

    public Dojo updateDojo(Long id, Dojo dojoData) {
        Dojo dojo = getDojo(id);
        dojoData.setId(dojo.getId());
        dojoData.setCreateDate(dojo.getCreateDate());
        dojoData.setUpdateDate(LocalDateTime.now());
        dojo = dojoRepository.save(dojoData);
        return dojo;
    }

    public void deleteDojo(Long id) {
        Dojo dojo = getDojo(id);
        dojoRepository.delete(dojo);
    }
}