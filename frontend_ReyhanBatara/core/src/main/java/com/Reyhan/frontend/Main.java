package com.Reyhan.frontend; // Ganti dengan nama package kalian
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.Reyhan.frontend.states.GameStateManager;
import com.Reyhan.frontend.states.PlayingState;
public class Main extends Game {
    private GameStateManager gsm;
    private SpriteBatch spriteBatch;
    @Override
    public void create() {
        spriteBatch = new SpriteBatch();
        gsm = new GameStateManager();
        gsm.push(new PlayingState(gsm));
    }
    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        gsm.update(Gdx.graphics.getDeltaTime());
        spriteBatch.begin();
        gsm.render(spriteBatch);
        spriteBatch.end();
    }
    @Override
    public void dispose() {
        super.dispose();
        gsm.pop();
        spriteBatch.dispose();// Dispose the current state

    }
}
