package com.james.IKO_Myanmar.controllers;

import com.james.IKO_Myanmar.dtos.ApiResponse;
import com.james.IKO_Myanmar.dtos.TournamentsPaginationRequest;
import com.james.IKO_Myanmar.models.Tournament;
import com.james.IKO_Myanmar.services.TournamentService;
import com.james.IKO_Myanmar.types.ApiData;
import com.james.IKO_Myanmar.types.PaginationData;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tournaments")
@Tag(name = "Tournament", description = "APIs to manage Tournament")
@RequiredArgsConstructor
public class TournamentController {
    private final TournamentService tournamentService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Tournament>>> getTournaments() {
        List<Tournament> tournaments = tournamentService.getTournaments();

        ApiResponse<List<Tournament>> apiResponse = ApiResponse.ok(tournaments, "");

        ResponseEntity<ApiResponse<List<Tournament>>> response = ResponseEntity.ok(apiResponse);

        return response;
    }

    @GetMapping("")
    public ResponseEntity<ApiResponse<PaginationData<Tournament>>> getTournamentsPagination(TournamentsPaginationRequest tournamentsPaginationRequest) {
        PaginationData<Tournament> tournamentsPagination = PaginationData.of(tournamentService.getTournamentsPagination(tournamentsPaginationRequest));

        ApiResponse<PaginationData<Tournament>> apiResponse = ApiResponse.ok(tournamentsPagination, "");

        ResponseEntity<ApiResponse<PaginationData<Tournament>>> response = ResponseEntity.ok(apiResponse);

        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Tournament>> getTournament(@PathVariable("id") Long id) {
        Tournament tournament = tournamentService.getTournament(id);

        ApiResponse<Tournament> apiResponse = ApiResponse.ok(tournament, "");

        ResponseEntity<ApiResponse<Tournament>> response = ResponseEntity.ok(apiResponse);

        return response;
    }

    @PostMapping("")
    public ResponseEntity<ApiResponse<Tournament>> postTournament(@RequestBody Tournament tournamentData) {
        Tournament tournament = tournamentService.createTournament(tournamentData);

        ApiResponse<Tournament> apiResponse = ApiResponse.ok(tournament, "");

        ResponseEntity<ApiResponse<Tournament>> response = ResponseEntity.ok(apiResponse);

        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Tournament>> putTournament(@PathVariable("id") Long id, @RequestBody Tournament tournamentData) {
        Tournament tournament = tournamentService.updateTournament(id, tournamentData);

        ApiResponse<Tournament> apiResponse = ApiResponse.ok(tournament, "");

        ResponseEntity<ApiResponse<Tournament>> response = ResponseEntity.ok(apiResponse);

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<ApiData<String>>> deleteTournament(@PathVariable("id") Long id) {
        tournamentService.deleteTournament(id);

        ApiResponse<ApiData<String>> apiResponse = ApiResponse.ok(
                ApiData.<String>builder()
                .url(String.format("/tournaments/%d", id))
                .method("DELETE")
                .content("Successfully deleted tournament")
                .build(),
                ""
        );

        ResponseEntity<ApiResponse<ApiData<String>>> response = ResponseEntity.ok(apiResponse);

        return response;
    }
}