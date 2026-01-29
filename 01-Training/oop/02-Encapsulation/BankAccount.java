public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            balance = initialBalance;
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance - amount >= 0) {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        account.deposit(500);
        account.withdraw(300);

        System.out.println("Final Balance: " + account.getBalance());
    }
}
