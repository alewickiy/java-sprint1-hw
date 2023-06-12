public class Converter {
    static final double KILOCALORIES_IN_STEP = 0.05;
    static final double KM_IN_STEP = 0.00075;

    int convertToKm(int steps) {
        return (int) (steps * KM_IN_STEP);
    }

    int convertStepsToKilocalories(int steps) {
        return (int) (steps * KILOCALORIES_IN_STEP);
    }
}
