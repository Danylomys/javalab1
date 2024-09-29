public class BankAccount {
    private String accountHolder;
    private String currency;
    private double balance;
    private Bank bank;

    public BankAccount(String accountHolder, String currency, Bank bank, double initialBalance) {
        this.accountHolder = accountHolder;
        this.currency = currency;
        this.bank = bank;
        this.balance = initialBalance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public String getCurrency() {
        return currency;
    }

    public double getBalance() {
        return balance;
    }

    public Bank getBank() {
        return bank;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Недостатньо коштів на рахунку");
        }
        balance -= amount;
    }

    public void transfer(BankAccount targetAccount, double amount) {
        double commissionRate = calculateCommission(targetAccount);
        double convertedAmount = bank.convertCurrency(amount, this.currency, targetAccount.getCurrency());
        double commission = convertedAmount * commissionRate;
        double finalAmount = convertedAmount - commission;

        this.withdraw(amount);

        targetAccount.deposit(finalAmount);

        System.out.printf("Переведено %.2f %s з рахунку %s (%s) на рахунок %s (%s). Комісія: %.2f %s%n",
                amount, this.currency, this.accountHolder, this.bank.getName(),
                targetAccount.getAccountHolder(), targetAccount.getBank().getName(),
                commission, targetAccount.getCurrency());
    }

    private double calculateCommission(BankAccount targetAccount) {
        if (this.accountHolder.equals(targetAccount.getAccountHolder())) {
            if (this.bank.equals(targetAccount.getBank())) {
                return 0.0; // Переказ між власними рахунками в одному банку
            } else {
                return 0.02; // Переказ між власними рахунками у різних банках
            }
        } else {
            if (this.bank.equals(targetAccount.getBank())) {
                return 0.03; // Переказ між рахунками різних користувачів в одному банку
            } else {
                return 0.06; // Переказ між рахунками різних користувачів у різних банках
            }
        }
    }
}

