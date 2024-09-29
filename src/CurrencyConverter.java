import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter {


    private static final HashMap<String, Double> exchangeRates = new HashMap<>();

    static {
        exchangeRates.put("UAH", 1.0);
        exchangeRates.put("USD", 36.8);
        exchangeRates.put("CAD", 27.2);
        exchangeRates.put("EUR", 40.0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть суму для конвертації (наприклад, 100 UAH into USD): ");
        String input = scanner.nextLine();

        try {

            String[] parts = input.split(" ");
            if (parts.length != 4 || !parts[2].equalsIgnoreCase("into")) {
                throw new IllegalArgumentException("Неправильний формат. Використовуйте формат '100 UAH into USD'.");
            }

            double amount = Double.parseDouble(parts[0]);
            String fromCurrency = parts[1].toUpperCase();
            String toCurrency = parts[3].toUpperCase();

            if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
                throw new IllegalArgumentException("Непідтримувана валюта. Підтримуються валюти: UAH, USD, CAD, EUR.");
            }

            double result = convertCurrency(amount, fromCurrency, toCurrency);

            System.out.printf("%.2f %s = %.2f %s%n", amount, fromCurrency, result, toCurrency);

        } catch (NumberFormatException e) {
            System.out.println("Помилка: невірний формат числа.");
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    private static double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        double amountInUAH = amount * exchangeRates.get(fromCurrency); // Перетворюємо у гривні
        return amountInUAH / exchangeRates.get(toCurrency);           // Конвертуємо у цільову валюту
    }
}
