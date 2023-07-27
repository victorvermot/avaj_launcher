import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class WeatherProvider {
    private static WeatherProvider INSTANCE;
    private String[] weather;
    int x_axis_length = 100;
    int y_axis_length = 100;
    int z_axis_length = 100;
    HashMap<Number, String> weatherTypes = new HashMap<Number, String>();
    ArrayList<ArrayList<ArrayList<String>>> space = new ArrayList<>(x_axis_length);

    public static WeatherProvider getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new WeatherProvider();
        }
        return INSTANCE;
    }

    private WeatherProvider() {
        weatherTypes.put(0, "RAIN");
        weatherTypes.put(1, "FOG");
        weatherTypes.put(2, "SUN");
        weatherTypes.put(3, "SNOW");
        for (int i = 0; i < x_axis_length; i++) {
            space.add(new ArrayList<ArrayList<String>>(y_axis_length));
            for (int j = 0; j < y_axis_length; j++) {
                space.get(i).add(new ArrayList<String>(z_axis_length));
            }
        }
        for (int i = 0; i < x_axis_length; i++) {
            for (int j = 0; j < y_axis_length; j++) {
                for (int k = 0; k < z_axis_length; k++) {
                    int randomNum = ThreadLocalRandom.current().nextInt(0, 4);
                    space.get(i).get(j).add(k, weatherTypes.get(randomNum));
                }
            }
        }
    }

    public String getCurrentWeather(Coordinates p_coordinates) {
        return (space.get(p_coordinates.getLongitude()).get(p_coordinates.getLatitude()).get(p_coordinates.getHeight()));
    }

}
