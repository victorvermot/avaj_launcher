import java.util.HashMap;

public class Baloon extends Aircraft {
    public Baloon(long p_id, String p_name, Coordinates p_coordinates, WeatherTower weatherTower) {
        super(p_id, p_name, p_coordinates, weatherTower);
        annoucmentsDict.put("RAIN", "The baloon is getting heavy because of the rain");
        annoucmentsDict.put("SUN", "The baloon is burning heavy because of the rain");
        annoucmentsDict.put("FOG", "Quoikoufog");
        annoucmentsDict.put("SNOW", "Quoikousnow");
    }

    public void updateConditions() {
        String currentWeather = this.weatherTower.getWeather(this.coordinates);
        System.out.println(this.name + ": " + annoucmentsDict.get(currentWeather));
    }
}
