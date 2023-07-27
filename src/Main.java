public class Main {
    public static void main(String[] args) {
        Parser test = new Parser("scenario.txt");
        WeatherProvider test2 = WeatherProvider.getInstance();
        SimulationRunner sim = new SimulationRunner(test.vehiclesList, test.getNumberOfSimulations());
        sim.startSimulation();
    }
}
