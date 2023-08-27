package com.vvermot.aircraft;
import com.vvermot.simulator.Coordinates;
import com.vvermot.simulator.WeatherTower;
public class Aircraft extends Flyable {
    public long id;
    protected String name;
    protected Coordinates coordinates;

    Aircraft(long p_id, String p_name, Coordinates p_coordinates, WeatherTower weatherTower) {
        id = p_id;
        name = p_name;
        coordinates = p_coordinates;
        this.registerTower(weatherTower);
        this.weatherTower.register(this, this.name);
    }

    public void updateConditions() {}
}
