package com.Reyhan.frontend.obstacles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.Reyhan.frontend.Player;

public class HomingMissile extends BaseObstacle {

    private Player target;
    private Vector2 velocity;
    private float speed = 200f;
    private float width = 40f;
    private float height = 20f;

    public HomingMissile(Vector2 startPosition) {
        super(startPosition, 0);
        this.velocity = new Vector2();
    }

    @Override
    public void initialize(Vector2 startPosition, int length) {
        super.initialize(startPosition, length);
        this.velocity.set(0, 0);
    }

    public void setTarget(Player target) {
        this.target = target;
    }

    public boolean isTargetingPlayer() {
        if (target == null) {
            return false;
        }
        float targetMidX = target.getCollider().x + target.getCollider().width / 2f;
        float missileMidX = position.x + width / 2f;
        return targetMidX > missileMidX;
    }

    public void update(float delta) {
        if (target != null && active) {
            if (isTargetingPlayer()) {
                Vector2 targetPosition = target.getPosition();
                velocity.set(targetPosition).sub(position).nor().scl(speed);
                position.x += velocity.x * delta;
                position.y += velocity.y * delta;
                updateCollider();
            }
        }
    }

    @Override
    protected void updateCollider() {
        collider = new Rectangle(position.x, position.y, width, height);
    }

    @Override
    protected void drawShape(ShapeRenderer shapeRenderer) {
        shapeRenderer.rect(position.x, position.y, width, height);
    }

    @Override
    public float getRenderWidth() {
        return width;
    }

    @Override
    public float getRenderHeight() {
        return height;
    }
}
