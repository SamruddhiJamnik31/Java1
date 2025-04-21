class DivisionException extends Exception {
    public DivisionException(String message) {
        super(message);
    }
}


class Calculator {
    public int divide(int a, int b) throws DivisionException {
        if (b == 0) {
            throw new DivisionException("Error: Division by zero is not allowed.");
        }
        return a / b;
    }
}


public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int a = 10;
        int b = 0;

        try {
            int result = calculator.divide(a, b);
            System.out.println("Result: " + result);
        } catch (DivisionException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
