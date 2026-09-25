package com.james.IKO_Myanmar.services;

import com.james.IKO_Myanmar.dtos.TournamentsPaginationRequest;
import com.james.IKO_Myanmar.exceptions.NotFoundException;
import com.james.IKO_Myanmar.models.Tournament;
import com.james.IKO_Myanmar.repositories.TournamentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TournamentService {
    private final TournamentRepository tournamentRepository;

    public Tournament createTournament(Tournament tournamentData) {
        Tournament tournament = null;
        tournamentData.setCreateDate(LocalDateTime.now());
        tournamentData.setUpdateDate(LocalDateTime.now());
        tournament = tournamentRepository.save(tournamentData);
        return tournament;
    }

    public List<Tournament> getTournaments() {
        return tournamentRepository.findAll();
    }

    public Page<Tournament> getTournamentsPagination(TournamentsPaginationRequest tournamentsPaginationRequest) {
        Pageable pageable = PageRequest.of(tournamentsPaginationRequest.getPage(), tournamentsPaginationRequest.getSize());
        Page<Tournament> tournamentsPagination = tournamentRepository.findAllBy(tournamentsPaginationRequest.getName(), tournamentsPaginationRequest.getDate(), tournamentsPaginationRequest.getType(), pageable);
        return tournamentsPagination;
    }

    public Tournament getTournament(Long id) {
        return tournamentRepository.findById(id).orElseThrow(() -> new NotFoundException("Tournament with id: " + id + " not found!"));
    }

    public Tournament updateTournament(Long id, Tournament tournamentData) {
        Tournament tournament = getTournament(id);
        tournamentData.setCreateDate(tournament.getCreateDate());
        tournamentData.setUpdateDate(LocalDateTime.now());
        tournament = tournamentRepository.save(tournamentData);
        return tournament;
    }

    public void deleteTournament(Long id) {
        Tournament tournament = getTournament(id);
        tournamentRepository.delete(tournament);
    }
}