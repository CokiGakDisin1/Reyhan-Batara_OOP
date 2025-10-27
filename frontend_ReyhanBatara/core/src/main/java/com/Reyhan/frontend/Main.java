package com.Reyhan.frontend;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Main extends ApplicationAdapter {
    private ShapeRenderer shapeRenderer;
    private float x, y;
    private float width = 50;
    private float height = 50;
    private Color color;

    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();
        x = Gdx.graphics.getWidth() / 2f - width / 2f;
        y = Gdx.graphics.getHeight() / 2f - height / 2f;
        color = Color.RED;
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        float speed = 200 * Gdx.graphics.getDeltaTime();

        if (Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.UP)) {
            y += speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            y -= speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            x -= speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            x += speed;
        }

        if (x < 0) x = 0;
        if (x + width > Gdx.graphics.getWidth()) x = Gdx.graphics.getWidth() - width;
        if (y < 0) y = 0;
        if (y + height > Gdx.graphics.getHeight()) y = Gdx.graphics.getHeight() - height;

        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            if (color == Color.RED) {
                color = Color.YELLOW;
                System.out.println("Warna berubah menjadi KUNING");
            } else if (color == Color.YELLOW) {
                color = Color.BLUE;
                System.out.println("Warna berubah menjadi BIRU");
            } else if (color == Color.BLUE) {
                color = Color.RED;
                System.out.println("Warna berubah menjadi MERAH");
            }
        }

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(color);
        shapeRenderer.rect(x, y, width, height);
        shapeRenderer.end();
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}
