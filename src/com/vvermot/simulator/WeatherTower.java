package com.vvermot.simulator;

public class WeatherTower extends Tower {

    public Meteo getWeather(Coordinates p_coordinates){
        return WeatherProvider.getInstance().getCurrentWeather(p_coordinates);
    }
    public void changeWeather() {
        this.conditionChanged();
    }
}
