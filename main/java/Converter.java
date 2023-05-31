public class Converter {

    int convertToKm(int steps) {
        if (steps == 0) {
            return 0;
        }
        return steps * 75 / 100000;
    }

    int convertStepsToKilocalories(int steps) {
        if (steps == 0) {
            return 0;
        }
        return steps * 50 / 1000;
    }
}
