package com.Reyhan.frontend;

import com.Reyhan.frontend.observers.Observer;
import com.Reyhan.frontend.observers.ScoreManager;

public class GameManager {
    private static GameManager instance;
    private ScoreManager scoreManager;
    private boolean gameStarted;

    private GameManager() {
        this.scoreManager = new ScoreManager();
        this.gameStarted = false;
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public void setScore(int newScore) {
        this.scoreManager.setScore(newScore);
    }

    public int getScore() {
        return this.scoreManager.getScore();
    }

    public void addObserver(Observer observer) {
        this.scoreManager.addObserver(observer);
    }

    public void removeObserver(Observer observer) {
        this.scoreManager.removeObserver(observer);
    }

    public void startGame() {
        this.gameStarted = true;
        setScore(0);
    }

    public boolean isGameStarted() {
        return gameStarted;
    }
}

