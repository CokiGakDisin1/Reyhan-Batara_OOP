package com.Reyhan.frontend;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Coin {
    private Vector2 position;
    private Rectangle collider;
    private float radius = 15f;
    private boolean active;
    private float bobOffset;
    private float bobSpeed = 5f;

    public Coin(Vector2 startPosition) {
        this.position = startPosition;
        this.collider = new Rectangle(startPosition.x, startPosition.y, radius * 2, radius * 2);
        this.active = true;
    }

    public void update(float delta) {
        bobOffset += delta * bobOffset;
        float bobY = (float) Math.sin(bobOffset) * 5f;

        collider.setPosition(position.x, position.y, bobY);
    }

    public void
}
