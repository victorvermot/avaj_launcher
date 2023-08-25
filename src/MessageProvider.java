import java.util.HashMap;
import java.util.Map;

public class MessageProvider {

    public static MessageProvider INSTANCE;
    protected Map<Meteo, String> baloonMessages = Map.of(
            Meteo.SUN, "Quoikousun",
            Meteo.FOG, "Quoikoufog",
            Meteo.SNOW, "Quoikousnow",
            Meteo.RAIN, "Quoikourain",
            Meteo.LANDED, "BALOON AU SOL FRR"
    );
    protected Map<Meteo, String> jetPlaneMessages = Map.of(
            Meteo.SUN, "Quoikousun",
            Meteo.FOG, "Quoikoufog",
            Meteo.SNOW, "Quoikousnow",
            Meteo.RAIN, "Quoikourain",
            Meteo.LANDED, "JETPLANE AU SOL FRR"
    );
    protected Map<Meteo, String> helicopterMessages = Map.of(
            Meteo.SUN, "Quoikousun",
            Meteo.FOG, "Quoikoufog",
            Meteo.SNOW, "Quoikousnow",
            Meteo.RAIN, "Quoikourain",
            Meteo.LANDED, "HELICO AU SOL FRR"
    );

    private static void initMessages() {
    }
    public static MessageProvider getInstance() {
        if (INSTANCE == null) {
            initMessages();
            INSTANCE = new MessageProvider();
        }
        return INSTANCE;
    }

    public String getMessage(Vehicles type, Meteo weather) {
        return switch (type) {
            case BALOON -> baloonMessages.get(weather);
            case JETPLANE -> jetPlaneMessages.get(weather);
            case HELICOPTER -> helicopterMessages.get(weather);
        };
    }

}
