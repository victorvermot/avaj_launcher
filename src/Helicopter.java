public class Helicopter extends Aircraft {

    public Helicopter(long p_id, String p_name, Coordinates p_coordinates, WeatherTower weatherTower) {
        super(p_id, p_name, p_coordinates, weatherTower);
    }
    public void updateConditions() {
        Meteo currentWeather = this.weatherTower.getWeather(this.coordinates);
        MessageManager.getInstance().saveMessage(this.name + ": ", Vehicles.HELICOPTER, currentWeather);
        switch (currentWeather) {
            case LANDED:
                this.weatherTower.unregister(this, this.name);
                break;
            case RAIN:
                this.coordinates.updateCoordinates(
                        this.coordinates.getLatitude(),
                        this.coordinates.getLongitude() + 5,
                        this.coordinates.getHeight()
                );
                break;
            case SUN:
                this.coordinates.updateCoordinates(
                        this.coordinates.getLatitude(),
                        this.coordinates.getLongitude() + 10,
                        this.coordinates.getHeight() + 2
                );
                break;
            case SNOW:
                this.coordinates.updateCoordinates(
                        this.coordinates.getLatitude(),
                        this.coordinates.getLongitude(),
                        this.coordinates.getHeight() - 12
                );
                break;
            case FOG:
                this.coordinates.updateCoordinates(
                        this.coordinates.getLatitude(),
                        this.coordinates.getLongitude() + 1,
                        this.coordinates.getHeight()
                );
                break;
        }
    }
}
