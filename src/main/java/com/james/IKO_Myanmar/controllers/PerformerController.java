package com.james.IKO_Myanmar.controllers;

import com.james.IKO_Myanmar.dtos.ApiResponse;
import com.james.IKO_Myanmar.dtos.PerformersPaginationRequest;
import com.james.IKO_Myanmar.models.Performer;
import com.james.IKO_Myanmar.services.PerformerService;
import com.james.IKO_Myanmar.types.ApiData;
import com.james.IKO_Myanmar.types.PaginationData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/performers")
@RequiredArgsConstructor
public class PerformerController {
    private final PerformerService performerService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Performer>>> getPerformers() {
        List<Performer> performers = performerService.getPerformers();

        ApiResponse<List<Performer>> apiResponse = ApiResponse.ok(performers, "");

        ResponseEntity<ApiResponse<List<Performer>>> response = ResponseEntity.ok(apiResponse);

        return response;
    }

    @GetMapping("")
    public ResponseEntity<ApiResponse<PaginationData<Performer>>> getPerformersPagination(PerformersPaginationRequest performersPaginationRequest) {
        PaginationData<Performer> performerPagination = PaginationData.of(performerService.getPerformersPagination(performersPaginationRequest));

        ApiResponse<PaginationData<Performer>> apiResponse = ApiResponse.ok(performerPagination, "");

        ResponseEntity<ApiResponse<PaginationData<Performer>>> response = ResponseEntity.ok(apiResponse);

        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Performer>> getPerformer(@PathVariable("id") Long id) {
        Performer performer = performerService.getPerformer(id);

        ApiResponse<Performer> apiResponse = ApiResponse.ok(performer, "");

        ResponseEntity<ApiResponse<Performer>> response = ResponseEntity.ok(apiResponse);

        return response;
    }

    @PostMapping("")
    public ResponseEntity<ApiResponse<Performer>> postPerformer(@RequestBody Performer performerData) {
        Performer performer = performerService.createPerformer(performerData);

        ApiResponse<Performer> apiResponse = ApiResponse.ok(performer, "");

        ResponseEntity<ApiResponse<Performer>> response = ResponseEntity.ok(apiResponse);

        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Performer>> putPerformer(@PathVariable("id") Long id, @RequestBody Performer performerData) {
        Performer performer = performerService.updatePerformer(id, performerData);

        ApiResponse<Performer> apiResponse = ApiResponse.ok(performer, "");

        ResponseEntity<ApiResponse<Performer>> response = ResponseEntity.ok(apiResponse);

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<ApiData<String>>> deletePerformer(@PathVariable("id") Long id) {
        performerService.deletePerformer(id);

        ApiResponse<ApiData<String>> apiResponse = ApiResponse.ok(
                ApiData.<String>builder()
                        .url(String.format("/performers/%d", id))
                        .method("DELETE")
                        .content("")
                        .build(),
                ""
        );

        ResponseEntity<ApiResponse<ApiData<String>>> response = ResponseEntity.ok(apiResponse);

        return response;
    }
}