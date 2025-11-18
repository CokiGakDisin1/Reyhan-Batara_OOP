package com.Reyhan.frontend.states;

import com.Reyhan.frontend.states.GameState;
import com.Reyhan.frontend.states.GameStateManager;
import com.Reyhan.frontend.states.PlayingState;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.Reyhan.frontend.strategies.DifficultyStrategy;

public class DifficultyTransitionState implements GameState {
    private final GameStateManager gsm;
    private final PlayingState playingState;
    private final DifficultyStrategy newStrategy;
    private final BitmapFont font;
    private float timer = 2f;

    public DifficultyTransitionState(GameStateManager gsm, PlayingState playingState, DifficultyStrategy newStrategy) {
        this.gsm = gsm;
        this.playingState = playingState;
        this.newStrategy = newStrategy;
        this.font = new BitmapFont();
    }

    @Override
    public void update(float delta) {
        timer -= delta;
        if (timer <= 0) {
            playingState.setDifficulty(newStrategy);
            gsm.pop();
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        playingState.render(batch);
        batch.begin();
        float w = com.badlogic.gdx.Gdx.graphics.getWidth();
        float h = com.badlogic.gdx.Gdx.graphics.getHeight();
        font.draw(batch, "DIFFICULTY INCREASED!", w / 2f - 80, h / 2f + 20);
        font.draw(batch, newStrategy.getClass().getSimpleName(), w / 2f - 60, h / 2f - 10);
        batch.end();
    }

    @Override
    public void dispose() {
        font.dispose();
    }
}
