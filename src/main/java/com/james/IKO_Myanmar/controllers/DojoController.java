package com.james.IKO_Myanmar.controllers;

import com.james.IKO_Myanmar.dtos.ApiResponse;
import com.james.IKO_Myanmar.dtos.DojosPaginationRequest;
import com.james.IKO_Myanmar.models.Dojo;
import com.james.IKO_Myanmar.services.DojoService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

/*@Controller*/ @RestController
public class DojoController {
    private final DojoService dojoService;

    public DojoController(DojoService dojoServiceDependency) {
        this.dojoService = dojoServiceDependency;
    }

    @GetMapping("/dojos/all")
    public ResponseEntity getDojos() {
        List<Dojo> dojos = dojoService.getDojos();

        ResponseEntity respone =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(dojos != null ? dojos : Collections.emptyList());

        return respone;
    }

    @GetMapping("/dojos")
    public ResponseEntity getDojosPagination(DojosPaginationRequest dojosPaginationRequest) {
        Page<Dojo> dojos = dojoService.getDojosPagination(dojosPaginationRequest);

        ApiResponse apiResponse = new ApiResponse<>(
                0000,
                "",
                LocalDateTime.now(),
                dojos
        );

        ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(apiResponse);

        return response;
    }

    @GetMapping("/dojos/{id}")
    public ResponseEntity getDojo(@PathVariable("id") Long id) {
        Dojo dojo = dojoService.getDojo(id);

        ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(dojo != null ? dojo : Collections.emptyMap());

        return response;
    }

    @PostMapping("/dojos")
    public ResponseEntity postDojo(@RequestBody Dojo dojoData) {
        Dojo dojo = dojoService.createDojo(dojoData);

        ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(dojo != null ? dojo : Collections.emptyMap());

        return response;
    }

    @PutMapping("/dojos/{id}")
    public ResponseEntity putDojo(@PathVariable("id") Long id, @RequestBody Dojo dojoData) {
        Dojo dojo = dojoService.updateDojo(id, dojoData);

        ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(dojo != null ? dojo : Collections.emptyMap());

        return response;
    }

    @DeleteMapping("/dojos/{id}")
    public ResponseEntity deleteDojo(@PathVariable("id") Long id) {
        dojoService.deleteDojo(id);

        /*ResponseEntity response =
                ResponseEntity.status(200)
                        .body(deleteSuccess ? "delete successful!" : "delete failed!");*/

        return new ResponseEntity(HttpStatus.OK);
    }
}