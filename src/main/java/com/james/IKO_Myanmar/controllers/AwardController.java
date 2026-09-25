package com.james.IKO_Myanmar.controllers;

import com.james.IKO_Myanmar.dtos.ApiResponse;
import com.james.IKO_Myanmar.dtos.AwardsPaginationRequest;
import com.james.IKO_Myanmar.models.Award;
import com.james.IKO_Myanmar.services.AwardService;
import com.james.IKO_Myanmar.types.ApiData;
import com.james.IKO_Myanmar.types.PaginationData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/awards")
@RequiredArgsConstructor
public class AwardController {
    private final AwardService awardService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Award>>> getAwards() {
        List<Award> awards = awardService.getAwards();

        ApiResponse<List<Award>> apiResponse = ApiResponse.ok(awards, "");

        ResponseEntity<ApiResponse<List<Award>>> response = ResponseEntity.ok(apiResponse);

        return response;
    }

    @GetMapping("")
    public ResponseEntity<ApiResponse<PaginationData<Award>>> getAwardsPagination(AwardsPaginationRequest awardsPaginationRequest) {
        PaginationData<Award> awardPagination = awardService.getAwardPagination(awardsPaginationRequest);

        ApiResponse<PaginationData<Award>> apiResponse = ApiResponse.ok(awardPagination, "");

        ResponseEntity<ApiResponse<PaginationData<Award>>> response = ResponseEntity.ok(apiResponse);

        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Award>> getAward(@PathVariable("id") Long id) {
        Award award = awardService.getAwardById(id);

        ApiResponse<Award> apiResponse = ApiResponse.ok(award, "");

        ResponseEntity<ApiResponse<Award>> response = ResponseEntity.ok(apiResponse);

        return response;
    }

    @PostMapping("")
    public ResponseEntity<ApiResponse<Award>> createAward(@RequestBody Award awardData) {
        Award award = awardService.createAward(awardData);

        ApiResponse<Award> apiResponse = ApiResponse.ok(award, "");

        ResponseEntity<ApiResponse<Award>> response = ResponseEntity.ok(apiResponse);

        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Award>> updateAward(@PathVariable("id") Long id, @RequestBody Award awardData) {
        Award award = awardService.updateAward(id, awardData);

        ApiResponse<Award> apiResponse = ApiResponse.ok(award, "");

        ResponseEntity<ApiResponse<Award>> response = ResponseEntity.ok(apiResponse);

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<ApiData<String>>> deleteAward(@PathVariable("id") Long id) {
        awardService.deleteAward(id);

        ApiResponse<ApiData<String>> apiResponse = ApiResponse.ok(
                ApiData.<String>builder()
                .method("DELETE")
                .url(String.format("/awards/%i", id))
                .content("Successfully deleted award")
                .build(),
                ""
        );

        ResponseEntity<ApiResponse<ApiData<String>>> response = ResponseEntity.ok(apiResponse);

        return response;
    }
}