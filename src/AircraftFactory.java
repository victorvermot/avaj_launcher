public final class AircraftFactory {
    private static AircraftFactory INSTANCE;
    private int id = 0;

    private AircraftFactory() {
    }

    public static AircraftFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AircraftFactory();
        }
        return INSTANCE;
    }

    Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates, WeatherTower weatherTower) {
        id++;
        if (p_type == null) {
            return null;
        }
        String entire_name = p_type + "#" + p_name + "(" + id + ")";
        if (p_type.equalsIgnoreCase("BALOON")) {
            return new Baloon(id, entire_name, p_coordinates, weatherTower);
        }
        else if (p_type.equalsIgnoreCase("JETPLANE")) {
            return new JetPlane(id, entire_name, p_coordinates, weatherTower);
        }
        else if (p_type.equalsIgnoreCase("HELICOPTER")) {
            return new Helicopter(id, entire_name, p_coordinates, weatherTower);
        }
        return null;
    }

}
