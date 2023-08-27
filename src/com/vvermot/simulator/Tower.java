package com.vvermot.simulator;

import java.util.ArrayList;
import java.util.List;

import com.vvermot.aircraft.Flyable;

public class Tower {
    private List<Flyable> observers = new ArrayList<>();
    public void register(Flyable p_flyable, String name) {
        MessageManager.getInstance().writeToFile("com.vvermot.simulator.Tower says: " + name + " registered to weather tower.");
        observers.add(p_flyable);
    }
    public void unregister(Flyable p_flyable, String name) {
        MessageManager.getInstance().writeToFile("com.vvermot.simulator.Tower says: " + name + " unregistered to weather tower.");
        observers.remove(p_flyable);
    }
    protected void conditionChanged() {
        for (int i=observers.size() - 1; i >= 0; i--) {
            observers.get(i).updateConditions();
        }
    }
}
