import java.util.Scanner;

class OddNumberException extends Exception {
    public OddNumberException(String message) {
        super(message);
    }
}

class NumberChecker {
    public void checkEven(int number) throws OddNumberException {
        if (number % 2 != 0) {
            throw new OddNumberException("Error: " + number + " is an odd number.");
        } else {
            System.out.println(number + " is an even number.");
        }
    }
}

public class OddNumberExceptionDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NumberChecker checker = new NumberChecker();

        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        try {
            checker.checkEven(number);
        } catch (OddNumberException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }

        scanner.close();
    }
}
