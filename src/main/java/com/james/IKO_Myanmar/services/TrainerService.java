package com.james.IKO_Myanmar.services;

import com.james.IKO_Myanmar.exceptions.NotFoundException;
import com.james.IKO_Myanmar.models.Trainer;
import com.james.IKO_Myanmar.repositories.TrainerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TrainerService {
    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepositoryDependency) {
        this.trainerRepository = trainerRepositoryDependency;
    }

    public Trainer createTrainer(Trainer trainerData) {
        trainerData.setCreateDate(LocalDateTime.now());
        return trainerRepository.save(trainerData);
    }

    public List<Trainer> getTrainers() {
        return trainerRepository.findAll();
    }

    public Trainer getTrainer(Long id) {
        return trainerRepository.findById(id).orElseThrow(() -> new NotFoundException("Trainer with id: " + id + " not found!"));
    }

    public Trainer updateTrainer(Long id, Trainer trainerData) {
        Trainer trainer = getTrainer(id);
        trainerData.setId(trainer.getId());
        trainerData.setCreateDate(trainer.getCreateDate());
        trainerData.setUpdateDate(LocalDateTime.now());
        trainer = trainerRepository.save(trainerData);
        return trainer;
    }

    public void deleteTrainer(Long id) {
        Trainer trainer = getTrainer(id);
        trainerRepository.delete(trainer);
    }
}