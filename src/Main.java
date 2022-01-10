import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Приветствуем вас в приложении \"Автоматизированная бухгалтерия\" ");
        Scanner scanner = new Scanner(System.in);
        Operation operation = new Operation();

        label:
        while (true) {

            printMenu();
            String command = scanner.next();

            switch (command) {
                case "1":
                    operation.getMonthlyReport();
                    break;
                case "2":
                    operation.getYearlyReport();
                    break;
                case "3":
                    operation.compareReports();
                    break;
                case "4":
                    operation.getInformationByMonths();
                    break;
                case "5":
                    operation.getInformationByYear();
                    break;
                case "escape":
                    System.out.println("Ждём вас снова :)");
                    scanner.close();
                    break label;
                default:
                    System.out.println("Извините, такой команды пока нет.");
                    break;
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
