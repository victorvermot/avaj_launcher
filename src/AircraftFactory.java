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
        return new Aircraft(1, p_name, p_coordinates);
    }

}
