public class JetPlane extends Aircraft {
    public JetPlane(long p_id, String p_name, Coordinates p_coordinates, WeatherTower weatherTower) {
        super(p_id, p_name, p_coordinates, weatherTower);
    }
    public void updateConditions() {
        Meteo currentWeather = this.weatherTower.getWeather(this.coordinates);
        System.out.println(this.name + ": " + MessageProvider.getInstance().getMessage(Vehicles.JETPLANE, currentWeather));
        switch (currentWeather) {
            case LANDED:
                this.weatherTower.unregister(this, this.name);
                break;
            case RAIN:
                this.coordinates.updateCoordinates(
                        this.coordinates.getLatitude() + 5,
                        this.coordinates.getLongitude(),
                        this.coordinates.getHeight()
                );
                break;
            case SUN:
                this.coordinates.updateCoordinates(
                        this.coordinates.getLatitude() + 10,
                        this.coordinates.getLongitude(),
                        this.coordinates.getHeight() + 2
                );
                break;
            case SNOW:
                this.coordinates.updateCoordinates(
                        this.coordinates.getLatitude(),
                        this.coordinates.getLongitude(),
                        this.coordinates.getHeight() - 7
                );
                break;
            case FOG:
                this.coordinates.updateCoordinates(
                        this.coordinates.getLatitude() + 1,
                        this.coordinates.getLongitude(),
                        this.coordinates.getHeight()
                );
                break;
        }
    }
}
