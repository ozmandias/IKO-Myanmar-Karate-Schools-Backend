package com.james.IKO_Myanmar.controllers;

import com.james.IKO_Myanmar.models.DojoOperator;
import com.james.IKO_Myanmar.services.DojoOperatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/*@Controller*/ @RestController
public class DojoOperatorController {
    private final DojoOperatorService dojoOperatorService;

    public DojoOperatorController(DojoOperatorService dojoOperatorServiceDependency) {
        this.dojoOperatorService = dojoOperatorServiceDependency;
    }

    @GetMapping("/dojo_operators")
    public ResponseEntity getDojoOperators() {
        List<DojoOperator> dojoOperators = dojoOperatorService.getDojoOperators();

        ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(dojoOperators != null ? dojoOperators : Collections.emptyList());

        return response;
    }

    @GetMapping("/dojo_operators/{id}")
    public ResponseEntity getDojoOperator(@PathVariable("id") Long id) {
        DojoOperator dojoOperator = dojoOperatorService.getDojoOperator(id);

        ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(dojoOperator !=null ? dojoOperator : Collections.emptyMap());

        return response;
    }

    @PostMapping("/dojo_operators")
    public ResponseEntity postDojoOperator(@RequestBody DojoOperator dojoOperatorData) {
        DojoOperator dojoOperator = dojoOperatorService.createDojoOperator(dojoOperatorData);

        ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(dojoOperator != null ? dojoOperator : Collections.emptyMap());

        return response;
    }

    @PutMapping("/dojo_operators/{id}")
    public ResponseEntity putDojoOperator(@PathVariable("id") Long id, @RequestBody DojoOperator dojoOperatorData) {
        DojoOperator dojoOperator = dojoOperatorService.updateDojoOperator(id, dojoOperatorData);

        ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(dojoOperator != null ? dojoOperator : Collections.emptyMap());

        return response;
    }

    @DeleteMapping("dojo_operators/{id}")
    public ResponseEntity deleteDojoOperator(@PathVariable("id") Long id) {
        dojoOperatorService.deleteDojoOperator(id);

        /*ResponseEntity response =
                ResponseEntity.status(200)
                        .body(deleteSuccess ? "delete successful!" : "delete failed!");*/

        return new ResponseEntity(HttpStatus.OK);
    }
}