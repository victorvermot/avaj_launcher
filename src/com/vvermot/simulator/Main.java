package com.vvermot.simulator;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("PROGRAM ABORTED NO ARGUMENT PROVIDED");
            return ;
        }
        WeatherTower weatherTower = new WeatherTower();
        Parser test = new Parser(args[0], weatherTower);
        if (!test.getIsFileCorrect()) {
            System.out.println("PROGRAM ABORTED");
            return ;
        }
        SimulationRunner program = new SimulationRunner(test.getNumberOfSimulations());
        program.startSimulation(weatherTower);
    }
}
