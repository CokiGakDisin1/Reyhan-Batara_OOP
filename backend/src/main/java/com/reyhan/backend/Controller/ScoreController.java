package com.reyhan.backend.Controller;

import com.reyhan.backend.model.Score;
import com.reyhan.backend.Service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/scores")
@CrossOrigin(origins = "*")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PostMapping
    public ResponseEntity<Score> create(@RequestBody Score score) {
        Score created = scoreService.createScore(score);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public List<Score> listAll() {
        return scoreService.getAllScores();
    }

    @GetMapping("/{scoreId}")
    public ResponseEntity<Optional<Score>> getById(@PathVariable UUID scoreId) {
        Optional<Score> opt = scoreService.getScoreById(scoreId);
        if (opt != null) {
            return ResponseEntity.ok(opt);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{scoreId}")
    public ResponseEntity<Score> update(@PathVariable UUID scoreId, @RequestBody Score score) {
        Score updated = scoreService.updateScore(scoreId, score);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{scoreId}")
    public ResponseEntity<String> delete(@PathVariable UUID scoreId) {
        scoreService.deleteScore(scoreId);
        return ResponseEntity.ok("Deleted");
    }

    @GetMapping("/player/{playerId}")
    public List<Score> getByPlayer(@PathVariable UUID playerId) {
        return scoreService.getScoresByPlayerId(playerId);
    }

    @GetMapping("/player/{playerId}/ordered")
    public List<Score> getByPlayerOrdered(@PathVariable UUID playerId) {
        return scoreService.getScoresByPlayerIdOrderByValue(playerId);
    }

    @GetMapping("/leaderboard")
    public List<Score> leaderboard(@RequestParam(defaultValue = "10") int limit) {
        return scoreService.getLeaderboard(limit);
    }

    @GetMapping("/player/{playerId}/highest")
    public ResponseEntity<? extends Object> highest(@PathVariable UUID playerId) {
        Optional<Score> opt = scoreService.getHighestScoreByPlayerId(playerId);
        if (opt != null) {
            return ResponseEntity.ok(opt);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/above/{minValue}")
    public List<Score> above(@PathVariable Integer minValue) {
        return scoreService.getScoresAboveValue(minValue);
    }

    @GetMapping("/recent")
    public List<Score> recent() {
        return scoreService.getRecentScores();
    }

    @GetMapping("/player/{playerId}/total-coins")
    public Map<String, Integer> totalCoins(@PathVariable UUID playerId) {
        int coins = scoreService.getTotalCoinsByPlayerId(playerId);
        return Collections.singletonMap("totalCoins", coins);
    }

    @GetMapping("/player/{playerId}/total-distance")
    public Map<String, Integer> totalDistance(@PathVariable UUID playerId) {
        int dist = scoreService.getTotalDistanceByPlayerId(playerId);
        return Collections.singletonMap("totalDistance", dist);
    }

    @DeleteMapping("/player/{playerId}")
    public ResponseEntity<String> deleteAllByPlayer(@PathVariable UUID playerId) {
        scoreService.deleteScoresByPlayerId(playerId);
        return ResponseEntity.ok("Deleted all scores for player");
    }
}
