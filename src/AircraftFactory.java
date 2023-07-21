public final class AircraftFactory {
    private static AircraftFactory INSTANCE;

    private AircraftFactory() {
    }

    public static AircraftFactory getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new AircraftFactory();
        }
        return INSTANCE;
    }

    Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
        if (p_type == null) {
            return null;
        }
        if (p_type.equalsIgnoreCase("BALOON")) {
            return new Baloon(1, p_name, p_coordinates);
        }
        else if (p_type.equalsIgnoreCase("JETPLANE")) {
            return new JetPlane(1, p_name, p_coordinates);
        }
        else if (p_type.equalsIgnoreCase("HELICOPTER")) {
            return new Baloon(1, p_name, p_coordinates);
        }
        return null;
    }

}
