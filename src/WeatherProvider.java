public class WeatherProvider {
    private static WeatherProvider INSTANCE;
    private String[] weather;

    private WeatherProvider() {}

    public String getCurrentWeather(Coordinates p_coordinates) {
        return "FOG";
    }

}
