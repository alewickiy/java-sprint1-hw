public class MonthData {
    int[] days = new int[30];

    int maxSteps() {
        int maxSteps = 0;
        for (int day : days) {
            if (day > maxSteps) {
                maxSteps = day;
            }
        }
        return maxSteps;
    }

    int bestSeriesPerMonth(int goalByStepsPerDay) {
        int bestSeriesCount = 0;
        int seriesTempCount = 0;
        for (int day : days) {
            if (day >= goalByStepsPerDay) {
                seriesTempCount++;
            } else {
                if (bestSeriesCount < seriesTempCount) {
                    bestSeriesCount = seriesTempCount;
                }
                seriesTempCount = 0;
            }
        }
        return bestSeriesCount;
    }
}
