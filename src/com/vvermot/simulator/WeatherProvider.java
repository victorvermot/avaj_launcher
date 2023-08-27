package com.vvermot.simulator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class WeatherProvider {
    public static WeatherProvider INSTANCE;
    private String[] weather;
    int x_axis_length = 1000;
    int y_axis_length = 1000;
    int z_axis_length = 100;
    HashMap<Number, Meteo> weatherTypes = new HashMap<>();
    ArrayList<ArrayList<ArrayList<Meteo>>> space = new ArrayList<>(x_axis_length);

    public static WeatherProvider getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new WeatherProvider();
        }
        return INSTANCE;
    }

    private WeatherProvider() {
        weatherTypes.put(0, Meteo.RAIN);
        weatherTypes.put(1, Meteo.FOG);
        weatherTypes.put(2, Meteo.SUN);
        weatherTypes.put(3, Meteo.SNOW);
        for (int i = 0; i < x_axis_length; i++) {
            space.add(new ArrayList<>(y_axis_length));
            for (int j = 0; j < y_axis_length; j++) {
                space.get(i).add(new ArrayList<>(z_axis_length));
            }
        }
        for (int i = 0; i < x_axis_length; i++) {
            for (int j = 0; j < y_axis_length; j++) {
                for (int k = 0; k < z_axis_length; k++) {
                    int randomNum = ThreadLocalRandom.current().nextInt(0, 4);
                    space.get(i).get(j).add(k, weatherTypes.get(randomNum));
                }
            }
        }
    }

    public Meteo getCurrentWeather(Coordinates p_coordinates) {
        if (p_coordinates.getHeight() >= 99) {
            p_coordinates.setHeight(99);
        }
        if (p_coordinates.getLatitude() >= 99) {
            p_coordinates.setHeight(99);
        }
        else if (p_coordinates.getHeight() <= 0) {
            return Meteo.LANDED;
        }
        return (space.get(p_coordinates.getLongitude()).get(p_coordinates.getLatitude()).get(p_coordinates.getHeight()));
    }

}
