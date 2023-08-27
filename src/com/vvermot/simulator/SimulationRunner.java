package com.vvermot.simulator;

public class SimulationRunner {
    private int numberOfSimulations;
    public SimulationRunner(int numberOfSimulations) {
        this.numberOfSimulations = numberOfSimulations;
    }

    public void startSimulation(WeatherTower weatherTower) {
        for (int i = 0; i < numberOfSimulations; i++) {
            weatherTower.changeWeather();
        }
        System.out.println("SIMULATION IS NOW FINISHED");
        MessageManager.getInstance().closeFile();
    }
}
