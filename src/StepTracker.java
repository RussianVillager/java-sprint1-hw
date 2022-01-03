import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class StepTracker {

    HashMap<String, ArrayList<Integer>> stepsAtDayInMonth;
    ArrayList<Integer> stepsByDay;
    int stepsTarget = 10000;
    Scanner scanner = new Scanner(System.in);
    String[] months = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};

    public StepTracker() {

        stepsAtDayInMonth = new HashMap<>();

        for (String month : months) {
            stepsByDay = new ArrayList<>();
            for (int j = 0; j < 30; j++) stepsByDay.add(0);
            stepsAtDayInMonth.put(month, stepsByDay);
        }
    }

    void saveStepsByDay () {
        String month;
        int day;
        int steps;

        while (true) {
        System.out.print("Введите название месяца с большой буквы: ");
        month = scanner.next();
            if (stepsAtDayInMonth.containsKey(month)) {
                break;
            } else {
                System.out.println("Введено некорректное название месяца, повторите попытку.");
            }
        }
        while (true) {
            System.out.print("Введите день, за который вы хотите указать количество шагов: ");
            day = scanner.nextInt();
            if (day > 0 && day <= 30) {
                break;
            } else {
                System.out.println("Введен некорректный номер дня, повторите попытку.");
            }
        }
        while (true) {
            System.out.print("Введите количество шагов за " + day + "-ый день: ");
            steps = scanner.nextInt();
            if (steps > 0) {
                break;
            } else {
                System.out.println("Введено некорректное количество шагов, повторите попытку.");
            }
        }
        stepsByDay.remove(day - 1);
        stepsByDay.add(day - 1, steps);
        stepsAtDayInMonth.put(month, stepsByDay);
        System.out.println("Количество шагов сохранено.");
        System.out.println("За " + month + " " + day + "-ого числа вы прошли " + steps + " шагов.");
        scanner.close();
    }

    void getStepsByDayStatistic (String month) {
        ArrayList<Integer> stepsByDayList = stepsAtDayInMonth.get(month);
        for (int i = 0; i < stepsByDay.size(); i++) System.out.println((i + 1) + " день: " + stepsByDayList.get(i));
    }

    Integer getSumOfStepsByMonth (String month) {
        int sum = 0;
        ArrayList<Integer> sumList = stepsAtDayInMonth.get(month);
        for (int i = 0; i < stepsByDay.size(); i++) {
            sum += sumList.get(i);
        }
        return sum;
    }

    Integer getMaxSteps (String month) {
        int max = 0;
        ArrayList<Integer> sumList = stepsAtDayInMonth.get(month);
        for (int i = 0; i < stepsByDay.size(); i++) {
            if (sumList.get(i) > max) max = sumList.get(i);
        }
        return max;
    }

    Integer getMeanOfSteps (String month) {
        int sum = 0;
        ArrayList<Integer> sumList = stepsAtDayInMonth.get(month);
        for (Integer steps : sumList) {
            sum += steps;
        }
        return sum/30;
    }

    Integer getBestSeries (String month) {
        HashMap<Integer, Integer> checkSeriesList = new HashMap<>();
        int seriesCounter = 0;
        int numberOfSeries = 1;
        int bestSeries = 0;
        ArrayList<Integer> seriesList = stepsAtDayInMonth.get(month);
        for (Integer steps : seriesList) {
            if (steps > stepsTarget) {
                seriesCounter += 1;
            } else {
                checkSeriesList.put(numberOfSeries, seriesCounter);
                numberOfSeries += 1;
                seriesCounter = 0;
            }
        }
        for (int j = 1; j < checkSeriesList.size(); j++) {
            if (checkSeriesList.get(j) > bestSeries) {
                bestSeries = checkSeriesList.get(j);
            }
        }
        return bestSeries;
    }

    void changeTarget () {
        while (true) {
            System.out.print("Введите целевое количество шагов за день: ");
            stepsTarget = scanner.nextInt();
            if (stepsTarget > 0) {
                break;
            } else {
                System.out.println("Введено некорректное количество шагов, повторите попытку.");
            }
        }
        System.out.println("Новое целевое количество шагов сохранено: " + stepsTarget + " шагов.");
        scanner.close();
    }
}
