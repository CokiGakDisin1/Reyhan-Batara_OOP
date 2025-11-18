package com.Reyhan.frontend.strategies;

import java.util.HashMap;
import java.util.Map;

public class EasyDifficultyStrategy implements DifficultyStrategy {
    @Override
    public float getSpawnInterval() {
        return 2.2f;
    }

    @Override
    public float getDensity() {
        return 1.2f;
    }

    @Override
    public float getMinGap() {
        return 280f;
    }

    @Override
    public Map<String, Integer> getObstacleWeights() {
        Map<String, Integer> map = new HashMap<>();
        map.put("VerticalLaser", 3);
        map.put("HorizontalLaser", 3);
        return map;
    }
}
