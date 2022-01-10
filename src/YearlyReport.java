import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class YearlyReport {

    ArrayList<String[]> yearlyReportLines = new ArrayList<>();

    String readFileContentsOrNull() {
        try {
            return Files.readString(Path.of("resources/y.2021.csv"));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

    void getYearlyReport() {
        String fileContents = readFileContentsOrNull();
        String[] lines = fileContents.split("\\n");
        for (int i = 1; i < lines.length; i++) {
            String[] lineContents = lines[i].split(",");
            yearlyReportLines.add(lineContents);
        }
    }

    Integer getYearlyIncomes(int month) {
        int sum = 0;
        for (String[] arrayReport : yearlyReportLines) {
            if (arrayReport[0].equals("0" + month) && arrayReport[2].equals("false")) {
                sum += Integer.parseInt(arrayReport[1]);
            }
        }
        return sum;
    }

    Integer getYearlyExpenses(int month) {
        int sum = 0;
        for (String[] arrayReport : yearlyReportLines) {
            if (arrayReport[0].equals("0" + month) && arrayReport[2].equals("true")) {
                sum += Integer.parseInt(arrayReport[1]);
            }
        }
        return sum;
    }

    Integer getProfitByMonth(int month) {
        int income = 0;
        int expense = 0;
        int profit = 0;
        for (String[] arrayReport : yearlyReportLines) {
            if (arrayReport[0].equals("0" + month) && arrayReport[2].equals("false")) {
                income = Integer.parseInt(arrayReport[1]);
            }
            if (arrayReport[0].equals("0" + month) && arrayReport[2].equals("true")) {
                expense = Integer.parseInt(arrayReport[1]);
            }
            profit = income - expense;
        }
        return profit;
    }
}
