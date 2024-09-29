public class Main {
    public static void main(String[] args) {
        // Створюємо два банки
        Bank bank1 = new Bank("Bank A");
        Bank bank2 = new Bank("Bank B");


        BankAccount account1 = new BankAccount("Zoya", "UAH", bank1, 10000.0);
        BankAccount account2 = new BankAccount("Sanya", "USD", bank2, 500.0);
        BankAccount account3 = new BankAccount("Marko", "EUR", bank1, 300.0);


        account1.transfer(account2, 1000.0);


        account1.transfer(account3, 2000.0);
    }
}
