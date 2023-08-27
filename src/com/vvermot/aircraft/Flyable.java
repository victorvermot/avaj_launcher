package com.vvermot.aircraft;
import com.vvermot.simulator.WeatherTower;
public abstract class Flyable {
    protected WeatherTower weatherTower;
    public abstract void updateConditions();
    public void registerTower(WeatherTower p_tower) {
        weatherTower = p_tower;
    }
}
