package com.james.IKO_Myanmar.services;

import com.james.IKO_Myanmar.dtos.AwardPaginationRequest;
import com.james.IKO_Myanmar.exceptions.NotFoundException;
import com.james.IKO_Myanmar.models.Award;
import com.james.IKO_Myanmar.repositories.AwardRepository;
import com.james.IKO_Myanmar.types.PaginationData;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AwardService {
    private final AwardRepository awardRepository;

    public List<Award> getAwards() {
        return awardRepository.findAll();
    }

    public Award getAwardById(Long id) {
        return awardRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Award with id: %i not found", id)));
    }

    public PaginationData<Award> getAwardPagination(AwardPaginationRequest awardPaginationRequest) {
        Pageable pageable = PageRequest.of(awardPaginationRequest.getPage(), awardPaginationRequest.getSize());
        PaginationData<Award> awardPagination = PaginationData.of(awardRepository.findAllBy(awardPaginationRequest.getName(), awardPaginationRequest.getAwardDate(), pageable));
        return awardPagination;
    }

    public Award createAward(Award awardData) {
        Award award = null;
        awardData.setCreateDate(LocalDateTime.now());
        awardData.setUpdateDate(LocalDateTime.now());
        award = awardRepository.save(awardData);
        return award;
    }

    public Award updateAward(Long id, Award awardData) {
        Award award = getAwardById(id);
        awardData.setId(award.getId());
        awardData.setCreateDate(award.getCreateDate());
        awardData.setUpdateDate(LocalDateTime.now());
        award = awardRepository.save(awardData);
        return award;
    }

    public void deleteAward(Long id) {
        Award award = getAwardById(id);
        awardRepository.delete(award);
        return;
    }
}