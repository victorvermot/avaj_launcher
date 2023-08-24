import java.util.HashMap;

public class Aircraft extends Flyable {
    public long id;
    protected String name;
    protected Coordinates coordinates;
    protected HashMap<String, String> annoucmentsDict = new HashMap<String, String>();

    Aircraft(long p_id, String p_name, Coordinates p_coordinates, WeatherTower weatherTower) {
        id = p_id;
        name = p_name;
        coordinates = p_coordinates;
        this.registerTower(weatherTower);
        this.weatherTower.register(this, this.name);
    }

    public void updateConditions() {
        System.out.println("Abstract method should not even be here");
    }
}
