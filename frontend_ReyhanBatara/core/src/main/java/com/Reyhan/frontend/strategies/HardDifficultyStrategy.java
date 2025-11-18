package com.Reyhan.frontend.strategies;

import java.util.HashMap;
import java.util.Map;

public class HardDifficultyStrategy implements DifficultyStrategy {
    @Override
    public float getSpawnInterval() {
        return 1.0f;
    }

    @Override
    public float getDensity() {
        return 3f;
    }

    @Override
    public float getMinGap() {
        return 200f;
    }

    @Override
    public Map<String, Integer> getObstacleWeights() {
        Map<String, Integer> map = new HashMap<>();
        map.put("VerticalLaser", 4);
        map.put("HorizontalLaser", 4);
        map.put("HomingMissile", 3);
        return map;
    }
}
