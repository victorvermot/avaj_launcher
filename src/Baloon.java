import java.util.HashMap;

public class Baloon extends Aircraft {
    public Baloon(long p_id, String p_name, Coordinates p_coordinates, WeatherTower weatherTower) {
        super(p_id, p_name, p_coordinates, weatherTower);
    }

    public void updateConditions() {
        Meteo currentWeather = this.weatherTower.getWeather(this.coordinates);
        MessageProvider.getInstance().saveMessage(this.name + ": ", Vehicles.BALOON, currentWeather);
        switch (currentWeather) {
            case LANDED:
                this.weatherTower.unregister(this, this.name);
                break;
            case RAIN:
                this.coordinates.updateCoordinates(
                        this.coordinates.getLatitude(),
                        this.coordinates.getLongitude(),
                        this.coordinates.getHeight() - 5
                );
                break;
            case SUN:
                this.coordinates.updateCoordinates(
                        this.coordinates.getLatitude(),
                        this.coordinates.getLongitude() + 2,
                        this.coordinates.getHeight() + 4
                );
                break;
            case SNOW:
                this.coordinates.updateCoordinates(
                        this.coordinates.getLatitude(),
                        this.coordinates.getLongitude(),
                        this.coordinates.getHeight() - 15
                );
                break;
            case FOG:
                this.coordinates.updateCoordinates(
                        this.coordinates.getLatitude(),
                        this.coordinates.getLongitude(),
                        this.coordinates.getHeight() - 3
                );
                break;
        }
    }
}
