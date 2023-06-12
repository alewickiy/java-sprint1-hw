import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        while (true) {
            printMenu();
            int userChoice = scanner.nextInt();
            switch (userChoice) {
                case 1:
                    System.out.printf("В этот день вы прошли %d шагов\n", stepTracker.stepsPerDayMonth());
                    break;
                case 2:
                    stepTracker.changeStepGoal();
                    break;
                case 3:
                    stepTracker.printStatistic();
                    break;
                case 4:
                    stepTracker.addNewNumberStepsPerDay();
                    break;
                case 0:
                    System.out.println("Удачи в достижении цели. До новых встреч");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Данная команда пока не поддерживается.");

            }
        }
    }

    private static void printMenu() {
        System.out.println("Пожалуйста, выберете команду из меню.");
        System.out.println("1 - Показать количество шагов за определённый день");
        System.out.println("2 - Изменить цель по количеству шагов в день");
        System.out.println("3 - Показать статистику за определённый месяц");
        System.out.println("4 - Внести количество шагов за день");
        System.out.println("0 - Выход");
    }
}
