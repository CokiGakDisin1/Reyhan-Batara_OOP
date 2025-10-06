package com.reyhan.backend.Repository;

import com.reyhan.backend.model.Score;
import java.util.*;
import java.util.stream.Collectors;

public class Scorerepository extends BaseRepository<Score, UUID> {

    @Override
    public void save(Score score) {
        UUID id = getId(score);
        dataMap.put(id, score);
        if (!allData.contains(score)) {
            allData.add(score);
        }
    }

    @Override
    public UUID getId(Score entity) {
        return entity.getScoreId();
    }

    public List<Score> findByPlayerId(UUID playerId) {
        return allData.stream()
                .filter(score -> score.getPlayerId().equals(playerId))
                .collect(Collectors.toList());
    }

    public List<Score> findByPlayerIdOrderByValueDesc(UUID playerId) {
        return allData.stream()
                .filter(score -> score.getPlayerId().equals(playerId))
                .sorted((s1, s2) -> Integer.compare(s2.getValue(), s1.getValue()))
                .collect(Collectors.toList());
    }

    public List<Score> findByValueGreaterThan(int minValue) {
        return allData.stream()
                .filter(score -> score.getValue() > minValue)
                .collect(Collectors.toList());
    }

    public List<Score> findAllByOrderByCreatedAtDesc() {
        return allData.stream()
                .sorted((s1, s2) -> s2.getCreatedAt().compareTo(s1.getCreatedAt()))
                .collect(Collectors.toList());
    }

    public List<Score> findTopScores(int limit) {
        return allData.stream()
                .sorted((s1, s2) -> Integer.compare(s2.getValue(), s1.getValue()))
                .limit(limit)
                .collect(Collectors.toList());
    }

    public Optional<Score> findHighestScoreByPlayerId(UUID playerId) {
        return allData.stream()
                .filter(score -> score.getPlayerId().equals(playerId))
                .max((s1, s2) -> Integer.compare(s1.getValue(), s2.getValue()));
    }

    public int getTotalCoinsByPlayerId(UUID playerId) {
        return allData.stream()
                .filter(score -> score.getPlayerId().equals(playerId))
                .mapToInt(Score::getCoinsCollected)
                .sum();
    }

    public int getTotalDistanceByPlayerId(UUID playerId) {
        return allData.stream()
                .filter(score -> score.getPlayerId().equals(playerId))
                .mapToInt(Score::getDistanceTravelled)
                .sum();
    }
}
