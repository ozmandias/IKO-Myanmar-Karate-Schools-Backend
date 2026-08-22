package com.james.IKO_Myanmar.services;

import com.james.IKO_Myanmar.dtos.TrainingsPaginationRequest;
import com.james.IKO_Myanmar.exceptions.NotFoundException;
import com.james.IKO_Myanmar.models.Training;
import com.james.IKO_Myanmar.repositories.TrainingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TrainingService {
    private final TrainingRepository trainingRepository;

    public TrainingService(TrainingRepository trainingRepositoryDependency) {
        this.trainingRepository = trainingRepositoryDependency;
    }

    public Training createTraining(Training trainingData) {
        trainingData.setCreateDate(LocalDateTime.now());
        return trainingRepository.save(trainingData);
    }

    public List<Training> getTrainings() {
        return trainingRepository.findAll();
    }

    public Page<Training> getTrainingsPagination(TrainingsPaginationRequest trainingsPaginationRequest) {
        Pageable pageable = PageRequest.of(trainingsPaginationRequest.getPage(), trainingsPaginationRequest.getSize());
        Page<Training> trainingsPagination = trainingRepository.findAllBy(
          trainingsPaginationRequest.getDate(),
          pageable
        );
        return trainingsPagination;
    }

    public Training getTraining(Long id) {
        return trainingRepository.findById(id).orElseThrow(() -> new NotFoundException("Training with id: " + id + " not found!"));
    }

    public Training updateTraining(Long id, Training trainingData) {
        Training training = getTraining(id);
        trainingData.setId(training.getId());
        trainingData.setCreateDate(training.getCreateDate());
        trainingData.setUpdateDate(LocalDateTime.now());
        training = trainingRepository.save(trainingData);
        return training;
    }

    public void deleteTraining(Long id) {
        Training training = getTraining(id);
        trainingRepository.delete(training);
    }
}