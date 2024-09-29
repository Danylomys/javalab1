import java.util.HashMap;

public class Bank {
    private String name;
    private HashMap<String, Double> exchangeRates;

    public Bank(String name) {
        this.name = name;
        exchangeRates = new HashMap<>();
        exchangeRates.put("UAH", 1.0); // Базова валюта
        exchangeRates.put("USD", 36.8);
        exchangeRates.put("CAD", 27.2);
        exchangeRates.put("EUR", 40.0);
    }

    public String getName() {
        return name;
    }

    public double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        if (fromCurrency.equals(toCurrency)) {
            return amount; // Якщо валюти однакові, конвертація не потрібна
        }

        double amountInUAH = amount * exchangeRates.get(fromCurrency);

        return amountInUAH / exchangeRates.get(toCurrency);
    }
}
