/**/import java.util.Scanner;

public class StepTracker {

    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 10000;
    Converter converter = new Converter();

    public StepTracker(Scanner scanner) {
        this.scanner = scanner;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        int monthNumber = scanner.nextInt();
        if (monthNumber < 1 || monthNumber > 12) {
            System.out.println("Неверно введен номер месяца.");
            return;
        }
        System.out.println("Введите день от 1 до 30 (включительно)");
        int dayNumber = scanner.nextInt();
        if (dayNumber < 1 || dayNumber > 30) {
            System.out.println("Неверно введен день.");
            return;
        }
        System.out.println("Введите количество шагов");
        int stepCount = scanner.nextInt();
        if (stepCount < 0) {
            System.out.println("Количество шагов не может быть отрицательным.");
            return;
        }
        MonthData monthData = monthToData[monthNumber - 1];
        monthData.days[dayNumber - 1] = stepCount;
        System.out.println();
    }

    void changeStepGoal() {
        System.out.println("Введите цель");
        int goal = scanner.nextInt();
        if (goal <= 0) {
            System.out.println("Цель должна быть больше нуля.");
            System.out.println();
            return;
        }
        goalByStepsPerDay = goal;
        System.out.println();
    }

    void printStatistics() {
        System.out.println("Введите месяц");
        MonthData monthData = monthToData[scanner.nextInt() - 1];
        monthData.printDaysAndStepsFromMonth();
        int commonSteps = monthData.sumStepsFromMonth();
        System.out.println("Общее количество шагов за месяц " + commonSteps);
        System.out.println("Макс. количество шагов " + monthData.maxSteps());
        System.out.println("Дистанция в км за месяц " + converter.convertToKm(commonSteps));
        System.out.println("Калории за месяц " + converter.convertStepsToKilocalories(commonSteps));
        System.out.println("Лучшая серия " + monthData.bestSeries(goalByStepsPerDay));
        System.out.println();
    }
}
