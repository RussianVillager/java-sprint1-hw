import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Приветствуем вас в приложении \"Автоматизированная бухгалтерия\" ");
        Scanner scanner = new Scanner(System.in);
        Operation operation = new Operation();
        boolean isMonthlyRead = false;
        boolean isYearlyRead = false;

        while (true) {

            printMenu();
            String command = scanner.next();

            if ("1".equals(command)) {
                operation.getMonthlyReport();
                isMonthlyRead = true;
                System.out.println("Все месячные отчеты считаны!");
            } else if ("2".equals(command)) {
                operation.getYearlyReport();
                isYearlyRead = true;
                System.out.println("Годовой отчет считан!");
            } else if ("3".equals(command) && (isYearlyRead) && (isMonthlyRead)) {
                operation.compareReports();
            } else if ("4".equals(command) && (isMonthlyRead)) {
                operation.getInformationByMonths();
            } else if ("5".equals(command) && (isYearlyRead)) {
                operation.getInformationByYear();
            } else if ("escape".equals(command)) {
                System.out.println("Ждём вас снова :)");
                scanner.close();
                break;
            } else {
                System.out.println("Извините, такой команды пока нет или вы не считали необходимые отчеты");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("escape - Завершение работы приложения");
    }
}
