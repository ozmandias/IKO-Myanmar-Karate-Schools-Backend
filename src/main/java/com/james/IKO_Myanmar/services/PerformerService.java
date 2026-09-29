package com.james.IKO_Myanmar.services;

import com.james.IKO_Myanmar.dtos.PerformersPaginationRequest;
import com.james.IKO_Myanmar.exceptions.NotFoundException;
import com.james.IKO_Myanmar.models.Performer;
import com.james.IKO_Myanmar.repositories.PerformerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PerformerService {
    private final PerformerRepository performerRepository;

    public Performer createPerformer(Performer performerData) {
        Performer performer = null;
        performerData.setCreateDate(LocalDateTime.now());
        performerData.setUpdateDate(LocalDateTime.now());
        performer = performerRepository.save(performerData);
        return performer;
    }

    public List<Performer> getPerformers() {
        return performerRepository.findAll();
    }

    public Page<Performer> getPerformersPagination(PerformersPaginationRequest performersPaginationRequest) {
        Pageable pageable = PageRequest.of(performersPaginationRequest.getPage(), performersPaginationRequest.getSize());
        Page<Performer> fighersPagination = performerRepository.findAllBy(
                performersPaginationRequest.getName(),
                performersPaginationRequest.getAge(),
                performersPaginationRequest.getGender(),
                performersPaginationRequest.getWeightInKg(),
                performersPaginationRequest.getWeightInLb(),
                performersPaginationRequest.getRegisterDate(),
                pageable
        );
        return fighersPagination;
    }

    public Performer getPerformer(Long id) {
        return performerRepository.findById(id).orElseThrow(() -> {
            return new NotFoundException(String.format("Performer with id: %d not found!", id));
        });
    }

    public Performer getPerformerByUserId(Long userId) {
        return performerRepository.findByUserId(userId).orElseThrow(() -> {
            return new NotFoundException(String.format("Performer with user id: %d not found!", userId));
        });
    }

    public Performer updatePerformer(Long id, Performer performerData) {
        Performer performer = getPerformer(id);
        performerData.setId(performer.getId());
        performerData.setCreateDate(performer.getCreateDate());
        performerData.setUpdateDate(performer.getUpdateDate());
        performer = performerRepository.save(performerData);
        return performer;
    }

    public void deletePerformer(Long id) {
        Performer performer = getPerformer(id);
        performerRepository.delete(performer);
    }
}