package com.james.IKO_Myanmar.controllers;

import com.james.IKO_Myanmar.dtos.ApiResponse;
import com.james.IKO_Myanmar.dtos.FightersPaginationRequest;
import com.james.IKO_Myanmar.models.Fighter;
import com.james.IKO_Myanmar.services.FighterService;
import com.james.IKO_Myanmar.types.ApiData;
import com.james.IKO_Myanmar.types.PaginationData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fighters")
@RequiredArgsConstructor
public class FighterController {
    private final FighterService fighterService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Fighter>>> getFighters() {
        List<Fighter> fighters = fighterService.getFighters();

        ApiResponse<List<Fighter>> apiResponse = ApiResponse.ok(fighters, "");

        ResponseEntity<ApiResponse<List<Fighter>>> response = ResponseEntity.ok(apiResponse);

        return response;
    }

    @GetMapping("")
    public ResponseEntity<ApiResponse<PaginationData<Fighter>>> getFightersPagination(FightersPaginationRequest fightersPaginationRequest) {
        PaginationData<Fighter> fighterPagination = PaginationData.of(fighterService.getFightersPagination(fightersPaginationRequest));

        ApiResponse<PaginationData<Fighter>> apiResponse = ApiResponse.ok(fighterPagination, "");

        ResponseEntity<ApiResponse<PaginationData<Fighter>>> response = ResponseEntity.ok(apiResponse);

        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Fighter>> getFighter(@PathVariable("id") Long id) {
        Fighter fighter = fighterService.getFighter(id);

        ApiResponse<Fighter> apiResponse = ApiResponse.ok(fighter, "");

        ResponseEntity<ApiResponse<Fighter>> response = ResponseEntity.ok(apiResponse);

        return response;
    }

    @PostMapping("")
    public ResponseEntity<ApiResponse<Fighter>> postFighter(@RequestBody Fighter fighterData) {
        Fighter fighter = fighterService.createFighter(fighterData);

        ApiResponse<Fighter> apiResponse = ApiResponse.ok(fighter, "");

        ResponseEntity<ApiResponse<Fighter>> response = ResponseEntity.ok(apiResponse);

        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Fighter>> putFighter(@PathVariable("id") Long id, @RequestBody Fighter fighterData) {
        Fighter fighter = fighterService.updateFighter(id, fighterData);

        ApiResponse<Fighter> apiResponse = ApiResponse.ok(fighter, "");

        ResponseEntity<ApiResponse<Fighter>> response = ResponseEntity.ok(apiResponse);

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<ApiData<String>>> deleteFighter(@PathVariable("id") Long id) {
        fighterService.deleteFighter(id);

        ApiResponse<ApiData<String>> apiResponse = ApiResponse.ok(
            ApiData.<String>builder()
                    .url(String.format("/fighters/%d", id))
                    .method("DELETE")
                    .content("")
                    .build(),
            ""
        );

        ResponseEntity<ApiResponse<ApiData<String>>> response = ResponseEntity.ok(apiResponse);

        return response;
    }
}