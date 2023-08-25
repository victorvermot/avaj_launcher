import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MessageProvider {

    public static MessageProvider INSTANCE;
    BufferedWriter writer;
    private Map<Meteo, String> baloonMessages = Map.of(
            Meteo.SUN, "Quoikousun",
            Meteo.FOG, "Quoikoufog",
            Meteo.SNOW, "Quoikousnow",
            Meteo.RAIN, "Quoikourain",
            Meteo.LANDED, "BALOON AU SOL FRR"
    );
    private Map<Meteo, String> jetPlaneMessages = Map.of(
            Meteo.SUN, "Quoikousun",
            Meteo.FOG, "Quoikoufog",
            Meteo.SNOW, "Quoikousnow",
            Meteo.RAIN, "Quoikourain",
            Meteo.LANDED, "JETPLANE AU SOL FRR"
    );
    private Map<Meteo, String> helicopterMessages = Map.of(
            Meteo.SUN, "Quoikousun",
            Meteo.FOG, "Quoikoufog",
            Meteo.SNOW, "Quoikousnow",
            Meteo.RAIN, "Quoikourain",
            Meteo.LANDED, "HELICO AU SOL FRR"
    );

    public static MessageProvider getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MessageProvider();
        }
        return INSTANCE;
    }

    public void saveMessage(String prefix, Vehicles type, Meteo weather) {
        switch (type) {
            case BALOON -> writeToFile(prefix + baloonMessages.get(weather));
            case JETPLANE -> writeToFile(prefix + jetPlaneMessages.get(weather));
            case HELICOPTER -> writeToFile(prefix + helicopterMessages.get(weather));
        };
    }

    public void writeToFile(String newLine) {
        if (writer == null) {
            try {
                this.writer = new BufferedWriter(new FileWriter("simulation.txt"));
            }
            catch (IOException e) {
                System.out.println("Could not create output file");
            }
        }
        try {
            writer.append(newLine).append("\n");
        }
        catch (IOException e) {
            System.out.println("Could add new line in output file");
        }

    }

    public void closeFile() {
        try {
            writer.close();
        }
        catch (IOException e) {
            System.out.println("Could not delete output file");
        }
    }


}
