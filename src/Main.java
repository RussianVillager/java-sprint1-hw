import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Приветствуем вас в приложении \"Счётчик калорий\" ");
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        Converter converter = new Converter();

        while (true) {

            printMenu();
            int command = scanner.nextInt();

            if (command == 1) {
                stepTracker.saveStepsByDay();
            } else if (command == 2) {
                System.out.println("Введите название месяца (с большой буквы) за который вы хотите получить статистику:");
                String month = scanner.next();
                System.out.println("Количество пройденных шагов по дням:");
                stepTracker.getStepsByDayStatistic(month);
                System.out.println("Общее количество шагов за месяц:");
                System.out.println(stepTracker.getSumOfStepsByMonth(month));
                int steps = stepTracker.getSumOfStepsByMonth(month);
                System.out.println("Максимальное пройденное количество шагов в месяце:");
                System.out.println(stepTracker.getMaxSteps(month));
                System.out.println("Средне-пройденное количество шагов за месяц:");
                System.out.println(stepTracker.getMeanOfSteps(month));
                System.out.println("Пройденная дистанция за месяц:");
                System.out.println(converter.getDistance(steps));
                System.out.println("Количество сожжённых килокалорий за месяц:");
                System.out.println(converter.getBurnKiloCalories(steps));
                System.out.println("Лучшая серия за месяц:");
                System.out.println(stepTracker.getBestSeries(month));

            } else if (command == 3) {
                stepTracker.changeTarget();
            } else if (command == 0) {
                System.out.println("Ждём вас снова :)");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за выбранный день");
        System.out.println("2 - Получить статистику за выбранный месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выход из приложения");
    }
}
