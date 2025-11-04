package com.Reyhan.frontend;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color; // Import Color
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Ground {
    private static final float GROUND_HEIGHT = 50f;
    private Rectangle collider;

    public Ground() {
        this.collider = new Rectangle(0, 0, Gdx.graphics.getWidth() * 2, GROUND_HEIGHT);
    }

    public void update(float cameraX) {
        float groundWidth = Gdx.graphics.getWidth() * 3;
        this.collider.setPosition(cameraX - Gdx.graphics.getWidth() / 2f - 500, 0);
        this.collider.setWidth(groundWidth + 1000);
    }

    public boolean isColliding(Rectangle playerCollider) {
        return collider.overlaps(playerCollider);
    }

    public float getTopY() {
        return GROUND_HEIGHT;
    }

    public void render(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.rect(collider.x, collider.y, collider.width, collider.height);
    }
}
