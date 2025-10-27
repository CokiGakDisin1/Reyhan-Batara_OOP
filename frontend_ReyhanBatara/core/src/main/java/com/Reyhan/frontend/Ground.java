package com.Reyhan.frontend;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.awt.*;

public class Ground extends ApplicationAdapter {
    private static final float GROUND_HEIGHT = 50f;
    private Rectangle collider;

    public Ground(Rectangle collider) {
        this.collider = new Rectangle(0,0,2*Gdx.graphics.getWidth(),GROUND_HEIGHT);
    }

    public void update(float cameraX) {
        float groundWidth = Gdx.graphics.getWidth();
        this.collider.set
    }
}
