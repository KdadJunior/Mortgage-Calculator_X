import java.util.Scanner;
import java.text.NumberFormat;

public class Main {
    public static void main(String[] args) {

        int principal = (int)readNumber("pricipal: ", 1000, 1_000_000);
        float annualInterest = (float)readNumber("annualInterest: ", 1, 30);
        int years = (int)readNumber("Period(years): ", 1, 100);

        double mortgage = calculateMortgage(principal, annualInterest, years);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextFloat();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between" + min + "and" + max);
        }
        return value;
    }

    public static double calculateMortgage(
            int principal,
            float annualInterest,
            int years) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        int numberOfPayments = years * MONTHS_IN_YEAR;
        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1));

        return mortgage;
    }
}