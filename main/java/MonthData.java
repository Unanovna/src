public class MonthData {

    int[] days = new int[30];

    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println(i + 1 + " день: " + days[i]);
        }
    }

    int sumStepsFromMonth() {
        int result = 0;
        for (int day : days) {
            result += day;
        }
        return result;
    }

    int maxSteps() {
        int result = 0;
        for (int day : days) {
            if (day > result) {
                result = day;
            }
        }
        return result;
    }

    int bestSeries(int goalByStepsPerDay) {
        int bestSeries = 0;
        int result = 0;
        for (int day : days) {
            if (day >= goalByStepsPerDay) {
                result++;
            } else {
                if (result > bestSeries) {
                    bestSeries = result;
                    result = 0;
                }
            }
        }
        return bestSeries;
    }
}
