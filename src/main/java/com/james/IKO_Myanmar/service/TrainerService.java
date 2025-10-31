package com.james.IKO_Myanmar.service;

import com.james.IKO_Myanmar.model.Trainer;
import com.james.IKO_Myanmar.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TrainerService {
    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepositoryDependency) {
        this.trainerRepository = trainerRepositoryDependency;
    }

    public Trainer createTrainer(Trainer trainerData) {
        trainerData.create_date = LocalDateTime.now();
        return trainerRepository.save(trainerData);
    }

    public List<Trainer> getTrainers() {
        return trainerRepository.findAll();
    }

    public Optional<Trainer> getTrainer(Long id) {
        return trainerRepository.findById(id);
    }

    public Trainer updateTrainer(Long id, Trainer trainerData) {
        Optional<Trainer> optionalTrainer = getTrainer(id);
        Trainer trainer = null;
        if(optionalTrainer.isPresent()) {
            trainer = optionalTrainer.get();
            trainerData.id = trainer.id;
            trainerData.create_date = trainer.create_date;
            trainerData.update_date = LocalDateTime.now();
            trainer = trainerRepository.save(trainerData);
        }
        return trainer;
    }

    public boolean deleteTrainer(Long id) {
        boolean deleteStatus = false;
        Optional<Trainer> optionalTrainer = getTrainer(id);
        Trainer trainer = null;
        if(optionalTrainer.isPresent()) {
            trainer = optionalTrainer.get();
            trainerRepository.delete(trainer);
            deleteStatus = true;
        }
        return deleteStatus;
    }
}