package com.james.IKO_Myanmar.controllers;

import com.james.IKO_Myanmar.dtos.ApiResponse;
import com.james.IKO_Myanmar.dtos.TrainingsPaginationRequest;
import com.james.IKO_Myanmar.models.Training;
import com.james.IKO_Myanmar.services.TrainingService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

/*@Controller*/ @RestController
public class TrainingController {
    private final TrainingService trainingService;

    public TrainingController(TrainingService trainingServiceDependency) {
        trainingService = trainingServiceDependency;
    }

    @GetMapping("/trainings/all")
    public ResponseEntity getTrainings() {
        List<Training> trainings = trainingService.getTrainings();

        ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(trainings != null ? trainings : Collections.emptyList());

        return  response;
    }

    @GetMapping("/trainings")
    public ResponseEntity getTrainingsPagination(TrainingsPaginationRequest trainingsPaginationRequest) {
        Page<Training> trainings = trainingService.getTrainingsPagination(trainingsPaginationRequest);

        ApiResponse apiResponse = new ApiResponse(
                0000,
                "",
                LocalDateTime.now(),
                trainings
        );

        ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(apiResponse);
        
        return response;
    }

    @GetMapping("/trainings/{id}")
    public ResponseEntity getTraining(@PathVariable("id") Long id) {
        Training training = trainingService.getTraining(id);

        ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(training != null ? training : Collections.emptyMap());

        return response;
    }

    @PostMapping("/trainings")
    public ResponseEntity postTraining(@RequestBody Training trainingData) {
        Training training = trainingService.createTraining(trainingData);

        ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(training != null ? training : Collections.emptyMap());

        return response;
    }

    @PutMapping("/trainings/{id}")
    public ResponseEntity putTraining(@PathVariable("id") Long id, @RequestBody Training trainingData) {
        Training training = trainingService.updateTraining(id, trainingData);

        ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(training != null ? training : Collections.emptyMap());

        return response;
    }

    @DeleteMapping("/trainings/{id}")
    public ResponseEntity deleteTraining(@PathVariable("id") Long id) {
        trainingService.deleteTraining(id);

        /*ResponseEntity response =
                ResponseEntity.status(200)
                        .body(deleteSuccess ? "delete successful!" : "delete failed!");*/

        return new ResponseEntity<>(HttpStatus.OK);
    }
}