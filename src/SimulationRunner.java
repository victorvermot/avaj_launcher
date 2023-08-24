import java.util.ArrayList;
import java.util.List;

public class SimulationRunner {
    public List<Aircraft> vehiclesList = new ArrayList<>();
    private int numberOfSimulations;
    public SimulationRunner( List<Aircraft> vehiclesList, int numberOfSimulations) {
        this.numberOfSimulations = numberOfSimulations;
        this.vehiclesList = vehiclesList;
    }

    public void startSimulation(WeatherTower weatherTower) {
        for (int i = 0; i < numberOfSimulations; i++) {
            weatherTower.changeWeather();
        }
    }
}
