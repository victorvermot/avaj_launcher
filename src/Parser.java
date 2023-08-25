import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    private String filePath;
    private Boolean isFileCorrect;
    public List<Aircraft> vehiclesList = new ArrayList<>();
    private int numberOfSimulations;
    private WeatherTower weatherTower;
    private AircraftFactory aircraftFactory = AircraftFactory.getInstance();

    public Parser(String filePath, WeatherTower weatherTower) {
        this.filePath = filePath;
        this.weatherTower = weatherTower;
        this.isFileCorrect = true;
        parse();
    }

    public int getNumberOfSimulations() {
        return numberOfSimulations;
    }
    public Boolean getIsFileCorrect() { return isFileCorrect; }

    private void parse() {
        BufferedReader reader;
        boolean firstLine = true;

        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line != null) {
                if (firstLine) {
                    firstLine = false;
                    this.numberOfSimulations = Integer.parseInt(line);
                }
                else {
                    createVehiclesFromLine(line);
                }
                line = reader.readLine();
            }
            reader.close();
        }
        catch (IOException | NumberFormatException | IncorrectConfigLine e) {
            System.out.println("The following error was encountered while parsing the config file: " + e.getMessage() +
                    "\nThe file should have the following format:\n" +
                    "- FIRST LINE: [number_of_time_the_simulation_will_run]\n"+
                    "- NEXT LINES: [vehicle_type vehicle_name coordinate_x coordinate_y coordinate_z]"
            );
            this.isFileCorrect = false;
        }
    }

    public void createVehiclesFromLine(String line) throws IncorrectConfigLine {
        String[] result = line.split(" ");
        if (result.length != 5) {
            throw new IncorrectConfigLine("Line is wrong");
        }
        Coordinates coordinates = new Coordinates(Integer.parseInt(result[2]), Integer.parseInt(result[3]), Integer.parseInt(result[4]));
        Aircraft newVehicle = (Aircraft) aircraftFactory.newAircraft(result[0], result[1], coordinates, this.weatherTower);
        if (newVehicle == null) {
            throw new IncorrectConfigLine("Vehicle name is wrong");
        }
        vehiclesList.add(newVehicle);
    }

}
