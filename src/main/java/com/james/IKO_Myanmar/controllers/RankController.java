package com.james.IKO_Myanmar.controllers;

import com.james.IKO_Myanmar.models.Rank;
import com.james.IKO_Myanmar.services.RankService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/*@Controller*/ @RestController
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
        Rank rank = rankService.getRank(id);

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
        rankService.deleteRank(id);

        /*ResponseEntity response =
                ResponseEntity.status(200)
                        .body(deleteSuccess ? "delete successful!" : "delete failed!");*/

        return new ResponseEntity(HttpStatus.OK);
    }
}