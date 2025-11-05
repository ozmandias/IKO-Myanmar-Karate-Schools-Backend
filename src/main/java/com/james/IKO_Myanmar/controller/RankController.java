package com.james.IKO_Myanmar.controller;

import com.james.IKO_Myanmar.model.Rank;
import com.james.IKO_Myanmar.service.RankService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class RankController {
    private final RankService rankService;

    public RankController(RankService rankServiceDependency) {
        this.rankService = rankServiceDependency;
    }

    @GetMapping("/ranks")
    public ResponseEntity getRanks() {
        List<Rank> ranks = rankService.getRanks();

        ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "applicaiton/json")
                        .body(ranks != null ? ranks : Collections.emptyList());

        return response;
    }

    @GetMapping("/ranks/{id}")
    public ResponseEntity getRank(@PathVariable("id") int id) {
        Optional<Rank> optionalRank = rankService.getRank(id);
        Rank rank = null;
        if(optionalRank.isPresent()) {
            rank = optionalRank.get();
        }

        ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(rank != null ? rank : Collections.emptyList());

        return response;
    }

    @PostMapping("ranks")
    public ResponseEntity postRank(@RequestBody Rank rankData) {
        Rank rank = rankService.createRank(rankData);

        ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(rank != null ? rank : Collections.emptyMap());

        return response;
    }

    @PutMapping("ranks/{id}")
    public ResponseEntity putRank(@PathVariable("id") int id, @RequestBody Rank rankData) {
        Rank rank = rankService.updateRank(id, rankData);

        ResponseEntity response =
                ResponseEntity.status(200)
                        .header("Content-Type", "application/json")
                        .body(rank != null ? rank : Collections.emptyMap());

        return response;
    }

    @DeleteMapping("ranks/{id}")
    public ResponseEntity deleteRank(@PathVariable("id") int id) {
        boolean deleteSuccess = rankService.deleteRank(id);

        ResponseEntity response =
                ResponseEntity.status(200)
                        .body(deleteSuccess ? "delete successful!" : "delete failed!");

        return response;
    }
}