import java.util.Scanner;
class LowBalanceException extends Exception {
    public LowBalanceException(String message) {
        super(message);
    }
}

class NegativeNumberException extends Exception {
    public NegativeNumberException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance >= 0)
            this.balance = initialBalance;
        else
            this.balance = 0;
    }

    public void balanceEnquiry() {
        System.out.println("Current Balance: ₹" + balance);
    }

    public void deposit(double amount) throws NegativeNumberException {
        if (amount < 0) {
            throw new NegativeNumberException("Cannot deposit a negative amount.");
        }
        balance += amount;
        System.out.println("Deposited: ₹" + amount);
    }

    public void withdraw(double amount) throws NegativeNumberException, LowBalanceException {
        if (amount < 0) {
            throw new NegativeNumberException("Cannot withdraw a negative amount.");
        }
        if (amount > balance) {
            throw new LowBalanceException("Insufficient balance. Available: ₹" + balance);
        }
        balance -= amount;
        System.out.println("Withdrawn: ₹" + amount);
    }
}

public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter initial balance: ₹");
        double initialBalance = scanner.nextDouble();
        BankAccount account = new BankAccount(initialBalance);

        int choice;
        do {
            System.out.println("\n=== Bank Menu ===");
            System.out.println("1. Balance Enquiry");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        account.balanceEnquiry();
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: ₹");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw: ₹");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                        break;
                    case 4:
                        System.out.println("Thank you for using the bank app.");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (NegativeNumberException | LowBalanceException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 4);

        scanner.close();
    }
}
