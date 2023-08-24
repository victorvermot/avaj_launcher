public class Helicopter extends Aircraft {

    public Helicopter(long p_id, String p_name, Coordinates p_coordinates, WeatherTower weatherTower) {
        super(p_id, p_name, p_coordinates, weatherTower);
    }
    public void updateConditions() {
        this.weatherTower.getWeather(this.coordinates);
    }
}
