public class Main {
    public static void main(String[] args) {
        WeatherTower weatherTower = new WeatherTower();
        Parser test = new Parser("scenario.txt", weatherTower);
        if (!test.getIsFileCorrect()) {
            System.out.println("PROGRAM ABORTED");
            return ;
        }
        SimulationRunner program = new SimulationRunner(test.getNumberOfSimulations());
        program.startSimulation(weatherTower);
    }
}
