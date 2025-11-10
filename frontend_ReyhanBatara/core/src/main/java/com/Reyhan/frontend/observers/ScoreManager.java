package com.Reyhan.frontend.observers;

import java.util.ArrayList;
import java.util.List;

public class  ScoreManager implements Subject {
    private List<Observer> observers;
    private int score = 0;

    public ScoreManager() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer i : observers) {
            i.update(score);
        }
    }

    public void setNews(String score) {
        this.score = score;
        notifyObservers(score);
    }
}


