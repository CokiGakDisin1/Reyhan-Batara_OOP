package com.Reyhan.frontend.observers;
import java.util.ArrayList;
import java.util.List;

public class Subject implements Subject {
    @Override
    public void addObserver(Observer observer) {
        Observer.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        Observer.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
}
