package com.Reyhan.frontend.obstacles;

import java.util.List;

public interface ObstacleCreator {
    BaseObstacle create();
    void release(BaseObstacle obstacle);
    void releaseAll();
    List<BaseObstacle> getAllInUse();
    String getName();
}
