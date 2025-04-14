// Base class BankAccount
class BankAccount {
    // Instance variables
    private double balance;

    // Constructor to initialize the balance
    public BankAccount(double balance) {
        this.balance = balance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount);
        } else {
            System.out.println("Amount to deposit should be positive.");
        }
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew $" + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    // Method to check the current balance
    public double getBalance() {
        return balance;
    }
}

// Subclass SavingsAccount that overrides withdraw() method
class SavingsAccount extends BankAccount {
    // Constructor to initialize balance in SavingsAccount
    public SavingsAccount(double balance) {
        super(balance);  // Call constructor of BankAccount
    }

    // Overridden withdraw() method to prevent withdrawal below $100
    @Override
    public void withdraw(double amount) {
        if (getBalance() - amount >= 100) {
            super.withdraw(amount);  // Call the withdraw method of BankAccount
        } else {
            System.out.println("Cannot withdraw. Balance cannot go below $100.");
        }
    }
}

// Main class to test the BankAccount and SavingsAccount classes
public class BankAccountTest {
    public static void main(String[] args) {
        // Create a BankAccount object
        BankAccount account1 = new BankAccount(500);
        System.out.println("Initial Balance: $" + account1.getBalance());

        // Perform deposit and withdrawal
        account1.deposit(200);
        account1.withdraw(100);
        System.out.println("Balance after operations: $" + account1.getBalance());

        // Create a SavingsAccount object
        SavingsAccount savingsAccount = new SavingsAccount(500);
        System.out.println("\nInitial Savings Account Balance: $" + savingsAccount.getBalance());

        // Perform deposit and withdrawal with SavingsAccount
        savingsAccount.deposit(200);
        savingsAccount.withdraw(100);
        savingsAccount.withdraw(600); // This should not be allowed since it would drop below $100
        System.out.println("Balance after operations: $" + savingsAccount.getBalance());
    }
}
