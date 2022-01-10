
public class Operation {

    MonthlyReport monthlyReport = new MonthlyReport();
    YearlyReport yearlyReport = new YearlyReport();

    void getMonthlyReport() {
        monthlyReport.getMonthlyReport();
    }

    void getYearlyReport() {
        yearlyReport.getYearlyReport();
    }

    void compareReports() {
        for (int i = 1; i <= 3; i++) {
            int sumMonthlyIncomes = monthlyReport.getMonthlyIncomes(i);
            int sumYearlyIncomes = yearlyReport.getYearlyIncomes(i);
            int sumMonthlyExpenses = monthlyReport.getMonthlyExpenses(i);
            int sumYearlyExpenses = yearlyReport.getYearlyExpenses(i);
            if ((sumMonthlyIncomes != sumYearlyIncomes) && (sumMonthlyExpenses != sumYearlyExpenses)) {
                System.out.println("В месяце № " + i + " обнаружено несоответсвие");
            } else {
                System.out.println("Операция завершена успешно");
            }
        }
    }

    void getInformationByMonths() {
        for (int i = 1; i <= 3; i++) {
            String nameOfMonth;
            if (i == 1) {
                nameOfMonth = "Январь";
            } else if (i == 2) {
                nameOfMonth = "Февраль";
            } else {
                nameOfMonth = "Март";
            }
            System.out.println("За месяц " + nameOfMonth);
            System.out.println("Самый прибыльный товар - " + monthlyReport.getNameOfBestIncomeInMonth(i));
            System.out.println("Сумма прибыли - " + monthlyReport.getBestIncomeInMonth(i));
            System.out.println("Наибольшие траты на товар - " + monthlyReport.getNameOfBestExpenseInMonth(i));
            System.out.println("Сумма трат - " + monthlyReport.getBestExpenseInMonth(i));
        }
    }

    void getInformationByYear() {
        int yearlyIncomes = 0;
        int yearlyExpenses = 0;
        System.out.println("Рассматриваемый год " + 2021);
        for (int i = 1; i <= 3; i++) {
            String nameOfMonth;
            if (i == 1) {
                nameOfMonth = "Январь";
            } else if (i == 2) {
                nameOfMonth = "Февраль";
            } else {
                nameOfMonth = "Март";
            }
            System.out.println("За месяц " + nameOfMonth);
            System.out.println("Прибыль составила - " + yearlyReport.getProfitByMonth(i));

            yearlyIncomes += yearlyReport.getYearlyIncomes(i);
            yearlyExpenses += yearlyReport.getYearlyExpenses(i);
        }
        System.out.println("Средний доход за все месяцы в году " + yearlyIncomes / 3);
        System.out.println("Средний расход за все месяцы в году " + yearlyExpenses / 3);
    }
}