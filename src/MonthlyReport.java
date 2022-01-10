import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {

    HashMap<Integer, ArrayList<String[]>> monthlyReportTable = new HashMap<>();

    String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с годовым отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

    void getMonthlyReport() {

        String nameOfFile;
        for (int i = 1; i <= 3; i++) {
            nameOfFile = "m.20210" + i + ".csv";
            String fileContents = readFileContentsOrNull("resources/" + nameOfFile);
            String[] lines = fileContents.split("\\n");

            ArrayList<String[]> monthlyReportLines = new ArrayList<>();
            for (int j = 1; j < lines.length; j++) {
                String[] lineContents = lines[j].split(",");
                monthlyReportLines.add(lineContents);
            }
            monthlyReportTable.put(i, monthlyReportLines);
        }
    }

    Integer getMonthlyIncomes(int month) {

        int sum = 0;
        for (String[] reportArray : monthlyReportTable.get(month)) {
            if (reportArray[1].equals("FALSE")) {
                sum += Integer.parseInt(reportArray[2]) * Integer.parseInt(reportArray[3].trim());
            }
        }
        return sum;
    }

    Integer getMonthlyExpenses(int month) {
        int sum = 0;
        for (String[] reportArray : monthlyReportTable.get(month)) {
            if (reportArray[1].equals("TRUE")) {
                sum += Integer.parseInt(reportArray[2]) * Integer.parseInt(reportArray[3].trim());
            }
        }
        return sum;
    }

    Integer getBestIncomeInMonth(int month) {
        int sum;
        int bestIncome = 0;
        for (String[] arrayReport : monthlyReportTable.get(month)) {
            if (arrayReport[1].equals("FALSE")) {
                sum = Integer.parseInt(arrayReport[2]) * Integer.parseInt(arrayReport[3].trim());
                if (sum > bestIncome) {
                    bestIncome = sum;
                }
            }
        }
        return bestIncome;
    }

    String getNameOfBestIncomeInMonth(int month) {
        int sum;
        String nameOfProduct = "";
        for (String[] arrayReport : monthlyReportTable.get(month)) {
            if (arrayReport[1].equals("FALSE")) {
                sum = Integer.parseInt(arrayReport[2]) * Integer.parseInt(arrayReport[3].trim());
                if (sum == getBestIncomeInMonth(month)) {
                    nameOfProduct = arrayReport[0];
                }
            }
        }
        return nameOfProduct;
    }

    Integer getBestExpenseInMonth(int month) {
        int sum;
        int bestExpense = 0;
        for (String[] arrayReport : monthlyReportTable.get(month)) {
            if (arrayReport[1].equals("TRUE")) {
                sum = Integer.parseInt(arrayReport[2]) * Integer.parseInt(arrayReport[3].trim());
                if (sum > bestExpense) {
                    bestExpense = sum;
                }
            }
        }
        return bestExpense;
    }

    String getNameOfBestExpenseInMonth(int month) {
        int sum;
        String nameOfProduct = "";
        for (String[] arrayReport : monthlyReportTable.get(month)) {
            if (arrayReport[1].equals("TRUE")) {
                sum = Integer.parseInt(arrayReport[2]) * Integer.parseInt(arrayReport[3].trim());
                if (sum == getBestExpenseInMonth(month)) {
                    nameOfProduct = arrayReport[0];
                }
            }
        }
        return nameOfProduct;
    }
}