import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Parser {
    private String filePath;

    public Parser(String filePath) {
        this.filePath = filePath;
        parse();
    }
    private void parse() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();

            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Aircraft[] createAllVehicles() {
        System.out.println("cc");
        return null;
    }

}
