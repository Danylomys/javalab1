import java.util.Scanner;

public class Parser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть вираз (наприклад, 2 + 4 = ?): ");
        String expression = scanner.nextLine();

        try {
            expression = expression.replaceAll("\\s+", "");
            expression = expression.replaceAll("=", "");
            
            char operator = findOperator(expression);
            if (operator == 0) {
                throw new IllegalArgumentException("Неправильний формат виразу.");
            }

            String[] parts = expression.split("\\" + operator);
            if (parts.length != 2) {
                throw new IllegalArgumentException("Неправильний формат виразу.");
            }

            double num1 = Double.parseDouble(parts[0]);
            double num2 = Double.parseDouble(parts[1]);

            double result = calculate(num1, num2, operator);
            System.out.println("Результат: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Помилка: ділення на нуль.");
        } catch (NumberFormatException e) {
            System.out.println("Помилка: неправильний формат числа.");
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    private static char findOperator(String expression) {
        if (expression.contains("+")) return '+';
        if (expression.contains("-")) return '-';
        if (expression.contains("*")) return '*';
        if (expression.contains("/")) return '/';
        return 0;
    }

    private static double calculate(double num1, double num2, char operator) {
        switch (operator) {
            case '+': return num1 + num2;
            case '-': return num1 - num2;
            case '*': return num1 * num2;
            case '/':
                if (num2 == 0) throw new ArithmeticException();
                return num1 / num2;
            default: throw new IllegalArgumentException("Непідтримувана операція.");
        }
    }
}
