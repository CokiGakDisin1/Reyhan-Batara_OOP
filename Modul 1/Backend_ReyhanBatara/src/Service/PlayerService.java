package Service;

import Model.Score;
import Repository.PlayerRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class PlayerService extend playerRepository {






    public List<Score> findByPlayerId(UUID playerId) {
        return allData.stream()
                .filter(getPlayerId().equals(playerId))
                .collect(Collectors.toList());
    }



    public UUID getId(Score entity) {
        return entity.getScoreId();
    }

    public List<Score> findTopScores(int limit) {
        return allData.stream()
                .sorted((s1, s2) -> Integer.compare(s2.getValue(), s1.getValue()))
                .limit(limit)
                .collect(Collectors.toList());
    }

    public Integer getTotalCoinsByPlayerId(UUID playerId) {
        return allData.stream()
                .filter(score -> score.getPlayerId().equals(playerId))
                .mapToInt(Score::getCoinsCollected)
                .sum();
    }

    public Integer getTotalDistanceByPlayerId(UUID playerId) {
        return allData.stream()
                .filter(score -> score.getPlayerId().equals(playerId))
                .mapToInt(Score::getDistance)
                .sum();
    }
}


