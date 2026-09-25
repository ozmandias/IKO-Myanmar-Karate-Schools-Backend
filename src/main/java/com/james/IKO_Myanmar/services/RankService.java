package com.james.IKO_Myanmar.services;

import com.james.IKO_Myanmar.dtos.RanksPaginationRequest;
import com.james.IKO_Myanmar.models.Rank;
import com.james.IKO_Myanmar.repositories.RankRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankService {
    private final RankRepository rankRepository;

    public RankService(RankRepository rankRepositoryDependency) {
        rankRepository = rankRepositoryDependency;
    }

    public Rank createRank(Rank rankData) {
        return rankRepository.save(rankData);
    }

    public List<Rank> getRanks() {
        return rankRepository.findAll();
    }

    public Page<Rank> getRanksPagination(RanksPaginationRequest ranksPaginationRequest) {
        Pageable pageable = PageRequest.of(ranksPaginationRequest.getPage(), ranksPaginationRequest.getSize());
        Page<Rank> ranksPagination = rankRepository.findAllBy(ranksPaginationRequest.getTitle(), pageable);
        return ranksPagination;
    }

    public Rank getRank(int id) {
        return rankRepository.findById(id).orElseThrow();
    }

    public Rank updateRank(int id, Rank rankData) {
        Rank rank = getRank(id);
        rankData.setId(rank.getId());
        rank = rankRepository.save(rankData);
        return rank;
    }

    public void deleteRank(int id) {
        Rank rank = getRank(id);
        rankRepository.delete(rank);
    }
}