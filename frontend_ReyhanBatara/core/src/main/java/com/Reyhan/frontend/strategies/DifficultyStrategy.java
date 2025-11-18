package com.Reyhan.frontend.strategies;

import java.util.Map;

public interface DifficultyStrategy {
    float getSpawnInterval();
    float getDensity();
    float getMinGap();
    Map<String, Integer> getObstacleWeights();
}
