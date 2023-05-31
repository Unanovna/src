import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);
        while (true) {
            System.out.println("Ввод цели по количеству шагов в день - 0");
            System.out.println("Ввод пройденного количества шагов за день - 1");
            System.out.println("Вывод статистики за определённый месяц - 2");
            System.out.println("Выход - 3");
            int funcNumber = scanner.nextInt();
            if (funcNumber == 0) {
                stepTracker.changeStepGoal();
            } else if (funcNumber == 1) {
                stepTracker.addNewNumberStepsPerDay();
            } else if (funcNumber == 2) {
                stepTracker.printStatistics();
            } else if (funcNumber == 3) {
                System.out.println("Bye");
                scanner.close();
                return;
            } else {
                System.out.println("Команда под номером " + funcNumber + " не найдена.");
            }
        }
    }
}
