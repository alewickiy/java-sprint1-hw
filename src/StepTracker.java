import java.util.Scanner;

public class StepTracker {
    Converter converter = new Converter();
    int goalByStepsPerDay = 10000;
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];

    public StepTracker() {
        scanner = new Scanner(System.in);

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        int monthId = checkMonth();
        int dayId = checkDay();
        int stepsCount = checkSteps();
        monthToData[monthId].days[dayId] = stepsCount;
        System.out.println("Данные сохранены. \n");
    }

    void changeStepGoal() {
        while (true) {
            System.out.println("Введите новую цель по количеству шагов на день");
            int goalByStepsPerDay = scanner.nextInt();
            if (goalByStepsPerDay <= 0) {
                System.out.println("Пожалуйста, задайтесь целью делать не менее одного шага в день");
            } else {
                this.goalByStepsPerDay = goalByStepsPerDay;
                System.out.println("Цель сохранена. \n");
                break;
            }
        }
    }
    void printStatistic() {
        int monthId = checkMonth();
        int sumSteps = sumStepsFromMonth(monthId);
        printDaysAndStepsFromMonth(monthId);
        System.out.printf("Всего за месяц вы прошли: %d шагов\n", sumStepsFromMonth(monthId));
        System.out.printf("Максимальное количество шагов за день в месяце: %d\n", maxStepsMonth(monthId));
        System.out.printf("Среднее количество пройденных в день шагов: %d\n"
                , sumStepsFromMonth(monthId) / monthToData[monthId].days.length
        );
        System.out.printf("За месяц вы прошли %d км.\n", converter.convertToKm(sumSteps));
        System.out.printf("За этот месяц вы сожгли %d ккал.\n", converter.convertStepsToKilocalories(sumSteps));
        System.out.printf("Лучшая серия достигнутых целей %d дней подряд\n\n", bestSeries(monthId, goalByStepsPerDay));
    }
    private void printDaysAndStepsFromMonth(int monthId) {
        for (int i = 0; i < monthToData[monthId].days.length; i++) {
            System.out.println(i+1 + " day: " + monthToData[monthId].days[i]);
        }
        System.out.print("\n");
    }
    private int sumStepsFromMonth(int monthId) {
        int monthStepsCount = 0;
        for (int i = 0; i < monthToData[monthId].days.length; i++) {
            monthStepsCount = monthStepsCount + monthToData[monthId].days[i];
        }
        return monthStepsCount;
    }
    private int maxStepsMonth(int monthId) {
        return monthToData[monthId].maxSteps();
    }

    private int bestSeries(int monthId, int goalByStepsPerDay) {
        return monthToData[monthId].bestSeriesPerMonth(goalByStepsPerDay);
    }

    public int stepsPerDayMonth() {
        int monthId = checkMonth();
        int dayId = checkDay();
        return monthToData[monthId].days[dayId];
    }

    //TODO check!!!!*************

    int checkMonth() {
        int monthId;
        while (true) {
            System.out.print("Пожалуйста, выберете порядковый номер месяца (1-12): ");
            monthId = scanner.nextInt();
            if (monthId < 1 || monthId > 12) {
                System.out.println("Попробуйте ещё раз.");
            } else {
                return monthId - 1;
            }
        }
    }

    int checkDay() {
        int dayId;
        while (true) {
            System.out.print("Пожалуйста, выберете порядковый номер дня месяца (1-30): ");
            dayId = scanner.nextInt();
            if (dayId < 1 || dayId > 30) {
                System.out.println("Попробуйте ещё раз.");
            } else {
                return dayId - 1;
            }
        }
    }
    int checkSteps() {
        int steps;
        while (true) {
            System.out.print("Пожалуйста, введите количество шагов: ");
            steps = scanner.nextInt();
            if (steps < 0) {
                System.out.println("Количество шагов не может быть отрицательным. Попробуйте ещё раз.");
            } else {
                return steps;
            }
        }
    }
}
