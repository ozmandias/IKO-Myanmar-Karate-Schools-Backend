package com.james.IKO_Myanmar.services;

import com.james.IKO_Myanmar.dtos.FightersPaginationRequest;
import com.james.IKO_Myanmar.exceptions.NotFoundException;
import com.james.IKO_Myanmar.models.Fighter;
import com.james.IKO_Myanmar.repositories.FighterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FighterService {
    private final FighterRepository fighterRepository;

    public Fighter createFighter(Fighter fighterData) {
        Fighter fighter = null;
        fighterData.setCreateDate(LocalDateTime.now());
        fighterData.setUpdateDate(LocalDateTime.now());
        fighter = fighterRepository.save(fighterData);
        return fighter;
    }

    public List<Fighter> getFighters() {
        return fighterRepository.findAll();
    }

    public Page<Fighter> getFightersPagination(FightersPaginationRequest fightersPaginationRequest) {
        Pageable pageable = PageRequest.of(fightersPaginationRequest.getPage(), fightersPaginationRequest.getSize());
        Page<Fighter> fighersPagination = fighterRepository.findAllBy(
            fightersPaginationRequest.getName(),
            fightersPaginationRequest.getAge(),
            fightersPaginationRequest.getGender(),
            fightersPaginationRequest.getWeightInKg(),
            fightersPaginationRequest.getWeightInLb(),
            fightersPaginationRequest.getRegisterDate(),
            pageable
        );
        return fighersPagination;
    }

    public Fighter getFighter(Long id) {
        return fighterRepository.findById(id).orElseThrow(() -> {
            return new NotFoundException(String.format("Fighter with id: %d not found!", id));
        });
    }

    public Fighter getFighterByUserId(Long userId) {
        return fighterRepository.findByUserId(userId).orElseThrow(() -> {
            return new NotFoundException(String.format("Fighter with user id: %d not found!", userId));
        });
    }

    public Fighter updateFighter(Long id, Fighter fighterData) {
        Fighter fighter = getFighter(id);
        fighterData.setId(fighter.getId());
        fighterData.setCreateDate(fighter.getCreateDate());
        fighterData.setUpdateDate(fighter.getUpdateDate());
        fighter = fighterRepository.save(fighterData);
        return fighter;
    }

    public void deleteFighter(Long id) {
        Fighter fighter = getFighter(id);
        fighterRepository.delete(fighter);
    }
}