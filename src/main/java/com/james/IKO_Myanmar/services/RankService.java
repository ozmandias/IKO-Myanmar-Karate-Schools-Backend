package com.james.IKO_Myanmar.services;

import com.james.IKO_Myanmar.models.Rank;
import com.james.IKO_Myanmar.repositories.RankRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Rank> getRank(int id) {
        return rankRepository.findById(id);
    }

    public Rank updateRank(int id, Rank rankData) {
        Optional<Rank> optionalRank = getRank(id);
        Rank rank = null;
        if(optionalRank.isPresent()) {
            rank = optionalRank.get();
            rankData.id = rank.id;
            rank = rankRepository.save(rankData);
        }
        return rank;
    }

    public boolean deleteRank(int id) {
        boolean deleteStatus = false;
        Optional<Rank> optionalRank = getRank(id);
        Rank rank = null;
        if(optionalRank.isPresent()) {
            rank = optionalRank.get();
            rankRepository.delete(rank);
            deleteStatus = true;
        }
        return deleteStatus;
    }
}