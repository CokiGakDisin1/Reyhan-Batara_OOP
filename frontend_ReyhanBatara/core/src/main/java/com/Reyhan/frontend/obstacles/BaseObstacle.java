package com.Reyhan.frontend.obstacles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class BaseObstacle {
    protected Vector2 position;
    protected Rectangle collider;
    protected float length;
    protected final float WIDTH = 10f;
    protected boolean active = false;

    public BaseObstacle(Vector2 startPosition, int length) {
        this.position = startPosition;
        this.length = length;
        updateCollider();
    }

    public void initialize(Vector2 startPosition, int length) {
        this.position.set(position.x,position.y);
        this.length = length;
        updateCollider();
    }

    public void render(ShapeRenderer shapeRenderer) {
        if (active) {
            drawShape(ShapeRenderer shapeRenderer);
        }
    }

    public boolean isColliding(Rectangle playerCollider) {
        return this.active && playerCollider.overlaps(collider);
    }

    protected abstract void updateCollider();
    protected abstract void drawShape(ShapeRenderer);
    protected abstract float getRenderWidth();
    protected abstract float  getRenderHeight();
    public void setActive(boolean active) {

    }

}
