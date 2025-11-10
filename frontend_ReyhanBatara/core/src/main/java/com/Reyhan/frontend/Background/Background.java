package com.Reyhan.frontend.Background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Background {
    private Texture backgroundTexture;
    private TextureRegion backgroundRegion;
    private float width;
    private float height;
    private float currentCameraX;

    public Background() {
        this.backgroundTexture = new Texture(Gdx.files.internal("background.png"));
        this.backgroundRegion = new TextureRegion(backgroundTexture);
        this.width = 2688f;
        this.height = 1536f;
        this.currentCameraX = 0f;
    }

    public void update(float cameraX) {
        this.currentCameraX = cameraX;
    }

    public void render(SpriteBatch batch) {
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        float scale = screenHeight / height;
        float scaledWidth = width * scale;
        float scaledHeight = height * scale;

        float startX = currentCameraX - (screenWidth / 2);

        float startTileX = (float) Math.floor(startX / scaledWidth) * scaledWidth;
        float currentTileX = startTileX;

        while (currentTileX < startX + screenWidth) {
            batch.draw(backgroundRegion, currentTileX, 0, scaledWidth, scaledHeight);
            currentTileX += scaledWidth;
        }
    }

    public void dispose() {
        if (backgroundTexture != null) {
            backgroundTexture.dispose();
        }
    }
}
