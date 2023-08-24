public class Main {
    public static void main(String[] args) {
        WeatherTower weatherTower = new WeatherTower();
        Parser test = new Parser("scenario.txt", weatherTower);
        SimulationRunner program = new SimulationRunner(test.vehiclesList, test.getNumberOfSimulations());
        program.startSimulation(weatherTower);
    }
}
