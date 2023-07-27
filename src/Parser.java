import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    private String filePath;
    public List<Aircraft> vehiclesList = new ArrayList<>();
    private int numberOfSimulations;
    private AircraftFactory aircraftFactory = AircraftFactory.getInstance();

    public Parser(String filePath) {
        this.filePath = filePath;
        parse();
    }

    public int getNumberOfSimulations() {
        return numberOfSimulations;
    }

    private List<Aircraft> parse() {
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
            System.out.println(e.getMessage());
            return null;
        }
        return vehiclesList;
    }

    public void createVehiclesFromLine(String line) throws IncorrectConfigLine {
        String[] result = line.split(" ");
        if (result.length != 5) {
            throw new IncorrectConfigLine("Line is wrong");
        }
        Coordinates coordinates = new Coordinates(Integer.parseInt(result[2]), Integer.parseInt(result[3]), Integer.parseInt(result[4]));
        vehiclesList.add((Aircraft) aircraftFactory.newAircraft(result[0], result[1], coordinates));
    }

}
