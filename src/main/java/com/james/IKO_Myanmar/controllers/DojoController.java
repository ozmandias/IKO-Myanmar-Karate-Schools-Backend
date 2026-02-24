package com.james.IKO_Myanmar.controllers;

import com.james.IKO_Myanmar.models.Dojo;
import com.james.IKO_Myanmar.services.DojoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class DojoController {
    private final DojoService dojoService;

    public DojoController(DojoService dojoServiceDependency) {
        this.dojoService = dojoServiceDependency;
    }

    @GetMapping("/dojos")
    public ResponseEntity getDojos() {
        List<Dojo> dojos = dojoService.getDojos();

        ResponseEntity respone =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(dojos != null ? dojos : Collections.emptyList());

        return respone;
    }

    @GetMapping("/dojos/{id}")
    public ResponseEntity getDojo(@PathVariable("id") Long id) {
        Optional<Dojo> optionalDojo = dojoService.getDojo(id);
        Dojo dojo = null;
        if(optionalDojo.isPresent()) {
            dojo = optionalDojo.get();
        }

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
        boolean deleteSuccess = dojoService.deleteDojo(id);

        ResponseEntity response =
                ResponseEntity.status(200)
                        .body(deleteSuccess ? "delete successful!" : "delete failed!");

        return response;
    }
}