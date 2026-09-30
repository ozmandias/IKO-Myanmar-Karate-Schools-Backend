package com.james.IKO_Myanmar.services;

import com.james.IKO_Myanmar.dtos.MatchesPaginationRequest;
import com.james.IKO_Myanmar.exceptions.NotFoundException;
import com.james.IKO_Myanmar.models.Match;
import com.james.IKO_Myanmar.repositories.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchService {
    private final MatchRepository matchRepository;

    public Match createMatch(Match matchData) {
        Match match = null;
        matchData.setCreateDate(LocalDateTime.now());
        matchData.setUpdateDate(LocalDateTime.now());
        match = matchRepository.save(matchData);
        return match;
    }

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public Page<Match> getMatchesPagination(MatchesPaginationRequest matchesPaginationRequest) {
        Pageable pageable = PageRequest.of(matchesPaginationRequest.getPage(), matchesPaginationRequest.getSize());
        Page<Match> matchesPagination = matchRepository.findAllBy(
                matchesPaginationRequest.getTournamentId(),
                matchesPaginationRequest.getName(),
                matchesPaginationRequest.getNotes(),
                matchesPaginationRequest.getRounds(),
                matchesPaginationRequest.getDateTime(),
                pageable
        );
        return matchesPagination;
    }

    public Match getMatchById(Long id) {
        return matchRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Match with id: %d not found!", id)));
    }

    public Match updateMatch(Long id, Match matchData) {
        Match match = getMatchById(id);
        matchData.setId(match.getId());
        matchData.setCreateDate(match.getCreateDate());
        matchData.setUpdateDate(LocalDateTime.now());
        match = matchRepository.save(matchData);
        return match;
    }

    public void deleteMatch(Long id) {
        Match match = getMatchById(id);
        matchRepository.delete(match);
    }
}