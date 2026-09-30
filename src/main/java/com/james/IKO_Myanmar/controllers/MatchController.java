package com.james.IKO_Myanmar.controllers;

import com.james.IKO_Myanmar.dtos.ApiResponse;
import com.james.IKO_Myanmar.dtos.MatchesPaginationRequest;
import com.james.IKO_Myanmar.models.Match;
import com.james.IKO_Myanmar.services.MatchService;
import com.james.IKO_Myanmar.types.ApiData;
import com.james.IKO_Myanmar.types.PaginationData;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matches")
@Tag(name = "Tournament Match", description = "APIs to manage Tournament Match")
@RequiredArgsConstructor
public class MatchController {
    private final MatchService matchService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Match>>> getMatches() {
        List<Match> matches = matchService.getAllMatches();

        ApiResponse<List<Match>> apiResponse = ApiResponse.ok(matches, "");

        ResponseEntity<ApiResponse<List<Match>>> response = ResponseEntity.ok(apiResponse);

        return response;
    }

    @GetMapping("")
    public ResponseEntity<ApiResponse<PaginationData<Match>>> getMatchesPagination(MatchesPaginationRequest matchesPaginationRequest) {
        PaginationData<Match> matches = PaginationData.of(matchService.getMatchesPagination(matchesPaginationRequest));

        ApiResponse<PaginationData<Match>> apiResponse = ApiResponse.ok(matches, "");

        ResponseEntity<ApiResponse<PaginationData<Match>>> response = ResponseEntity.ok(apiResponse);

        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Match>> getMatch(@PathVariable("id") Long id) {
        Match match = matchService.getMatchById(id);

        ApiResponse<Match> apiResponse = ApiResponse.ok(match, "");

        ResponseEntity<ApiResponse<Match>> response = ResponseEntity.ok(apiResponse);

        return response;
    }

    @PostMapping("")
    public ResponseEntity<ApiResponse<Match>> postMatch(@RequestBody Match matchData) {
        Match match = matchService.createMatch(matchData);

        ApiResponse<Match> apiResponse = ApiResponse.ok(match, "");

        ResponseEntity<ApiResponse<Match>> response = ResponseEntity.ok(apiResponse);

        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Match>> putMatch(@PathVariable("id") Long id, Match matchData) {
        Match match = matchService.updateMatch(id, matchData);

        ApiResponse<Match> apiResponse = ApiResponse.ok(match, "");

        ResponseEntity<ApiResponse<Match>> response = ResponseEntity.ok(apiResponse);

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<ApiData<String>>> deleteMatch(@PathVariable("id") Long id) {
        matchService.deleteMatch(id);

        ApiResponse<ApiData<String>> apiResponse = ApiResponse.ok(
                ApiData.<String>builder()
                        .url(String.format("/matches/%d", id))
                        .method("DELETE")
                        .content("Successfully deleted match")
                        .build(),
                ""
        );

        ResponseEntity<ApiResponse<ApiData<String>>> response = ResponseEntity.ok(apiResponse);

        return response;
    }
}