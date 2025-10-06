package com.reyhan.backend.Service;

import com.reyhan.backend.Service.PlayerService;
import com.reyhan.backend.model.Score;
import com.reyhan.backend.Repository.ScoreRepository;
import com.reyhan.backend.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerService playerService;

    @Transactional
    public Score createScore(Score score) {
        if (!playerRepository.existsById(score.getPlayerId())) {
            throw new RuntimeException("Player not found with ID: " + score.getPlayerId());
        }
        Score saved = scoreRepository.save(score);
        playerService.updatePlayerStats(
                score.getPlayerId(),
                score.getValue(),
                score.getCoinsCollected(),
                score.getDistanceTravelled()
        );
        return saved;
    }

    public Optional<Score> getScoreById(UUID scoreId) {
        return scoreRepository.findById(scoreId);
    }

    public List<Score> getAllScores() {
        return scoreRepository.findAll();
    }

    public List<Score> getScoresByPlayerId(UUID playerId) {
        return scoreRepository.findByPlayerId(playerId);
    }

    public List<Score> getScoresByPlayerIdOrderByValue(UUID playerId) {
        return scoreRepository.findByPlayerIdOrderByValueDesc(playerId);
    }

    public List<Score> getLeaderboard(int limit) {
        return scoreRepository.findTopScores(limit);
    }

    public Optional<Score> getHighestScoreByPlayerId(UUID playerId) {
        List<Score> list = scoreRepository.findHighestScoreByPlayerId(playerId);
        if (list == null || List.of().isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(list.get(0));
    }

    public List<Score> getScoresAboveValue(Integer minValue) {
        return scoreRepository.findByValueGreaterThan(minValue);
    }

    public List<Score> getRecentScores() {
        return scoreRepository.findAllByOrderByCreatedAtDesc();
    }

    public Integer getTotalCoinsByPlayerId(UUID playerId) {
        Integer total = scoreRepository.getTotalCoinsByPlayerId(playerId);
        return total != null ? total : 0;
    }

    public Integer getTotalDistanceByPlayerId(UUID playerId) {
        Integer total = scoreRepository.getTotalDistanceByPlayerId(playerId);
        return total != null ? total : 0;
    }

    public Score updateScore(UUID scoreId, Score updatedScore) {
        Score existing = scoreRepository.findById(scoreId)
                .orElseThrow(() -> new RuntimeException("Score not found with ID: " + scoreId));

        if (updatedScore.getValue() != 0) {
            existing = new Score(existing.getPlayerId(),
                    updatedScore.getValue(),
                    existing.getCoinsCollected(),
                    existing.getDistanceTravelled());
        }
        if (updatedScore.getCoinsCollected() != 0) {
            existing = new Score(existing.getPlayerId(),
                    existing.getValue(),
                    updatedScore.getCoinsCollected(),
                    existing.getDistanceTravelled());
        }
        if (updatedScore.getDistanceTravelled() != 0) {
            existing = new Score(existing.getPlayerId(),
                    existing.getValue(),
                    existing.getCoinsCollected(),
                    updatedScore.getDistanceTravelled());
        }
        return scoreRepository.save(existing);
    }

    public void deleteScore(UUID scoreId) {
        if (!scoreRepository.existsById(scoreId)) {
            throw new RuntimeException("Score not found with ID: " + scoreId);
        }
        scoreRepository.deleteById(scoreId);
    }

    public void deleteScoresByPlayerId(UUID playerId) {
        List<Score> scores = scoreRepository.findByPlayerId(playerId);
        for (Score s : scores) {
            scoreRepository.delete(s);
        }
    }
}
