package com.james.IKO_Myanmar.service;

import com.james.IKO_Myanmar.model.Training;
import com.james.IKO_Myanmar.repository.TrainingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TrainingService {
    private final TrainingRepository trainingRepository;

    public TrainingService(TrainingRepository trainingRepositoryDependency) {
        this.trainingRepository = trainingRepositoryDependency;
    }

    public Training createTraining(Training trainingData) {
        trainingData.create_date = LocalDateTime.now();
        return trainingRepository.save(trainingData);
    }

    public List<Training> getTrainings() {
        return trainingRepository.findAll();
    }

    public Optional<Training> getTraining(Long id) {
        return trainingRepository.findById(id);
    }

    public Training updateTraining(Long id, Training trainingData) {
        Optional<Training> optionalTraining = getTraining(id);
        Training training = null;
        if(optionalTraining.isPresent()) {
            training = optionalTraining.get();
            trainingData.id = training.id;
            trainingData.create_date = training.create_date;
            trainingData.update_date = LocalDateTime.now();
            training = trainingRepository.save(trainingData);
        }
        return training;
    }

    public boolean deleteTraining(Long id) {
        boolean deleteStatus = false;
        Optional<Training> optionalTraining = getTraining(id);
        Training training = null;
        if(optionalTraining.isPresent()) {
            training = optionalTraining.get();
            trainingRepository.delete(training);
            deleteStatus = true;
        }
        return deleteStatus;
    }
}