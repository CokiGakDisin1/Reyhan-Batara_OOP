package com.Reyhan.frontend.strategies;

import java.util.HashMap;
import java.util.Map;

public class MediumDifficultyStrategy implements DifficultyStrategy {
    @Override
    public float getSpawnInterval() {
        return 1.6f;
    }

    @Override
    public float getDensity() {
        return 2f;
    }

    @Override
    public float getMinGap() {
        return 240f;
    }

    @Override
    public Map<String, Integer> getObstacleWeights() {
        Map<String, Integer> map = new HashMap<>();
        map.put("VerticalLaser", 4);
        map.put("HorizontalLaser", 4);
        map.put("HomingMissile", 2);
        return map;
    }
}
