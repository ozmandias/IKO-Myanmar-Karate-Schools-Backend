package com.james.IKO_Myanmar.controllers;

import com.james.IKO_Myanmar.models.Trainer;
import com.james.IKO_Myanmar.services.TrainerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/*@Controller*/ @RestController
public class TrainerController {
    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerServiceDependency) {
        this.trainerService = trainerServiceDependency;
    }

    @GetMapping("/trainers")
    public ResponseEntity getTrainers() {
        List<Trainer> trainers = trainerService.getTrainers();

        ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(trainers != null ? trainers : Collections.emptyList());

        return response;
    }

    @GetMapping("/trainers/{id}")
    public ResponseEntity getTrainer(@PathVariable("id") Long id) {
        Optional<Trainer> optionalTrainer = trainerService.getTrainer(id);
        Trainer trainer = null;
        if(optionalTrainer.isPresent()) {
            trainer = optionalTrainer.get();
        }

        ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(trainer != null ? trainer : Collections.emptyMap());

        return response;
    }

    @PostMapping("/trainers")
    public ResponseEntity postTrainer(@RequestBody Trainer trainerData) {
        Trainer trainer = trainerService.createTrainer(trainerData);

        ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(trainer != null ? trainer : Collections.emptyMap());

        return response;
    }

    @PutMapping("/trainers/{id}")
    public ResponseEntity putTrainer(@PathVariable("id") Long id, @RequestBody Trainer trainerData) {
        Trainer trainer = trainerService.updateTrainer(id, trainerData);

        ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(trainer != null ? trainer : Collections.emptyMap());

        return response;
    }

    @DeleteMapping("/trainers/{id}")
    public ResponseEntity deleteTrainer(@PathVariable("id") Long id) {
        boolean deleteSuccess = trainerService.deleteTrainer(id);

        ResponseEntity response =
                ResponseEntity.status(200)
                        .body(deleteSuccess ? "delete successful!" : "delete failed!");

        return response;
    }
}