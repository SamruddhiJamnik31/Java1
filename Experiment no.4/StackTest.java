import java.util.Scanner;

interface Stack {
    int size = 5;

    void push(int value);
    int pop();
    void display();
    boolean overflow();
    boolean underflow();
}

class IntegerStack implements Stack {
    private int[] stack;
    private int top;

    public IntegerStack() {
        stack = new int[size];
        top = -1;
    }

    @Override
    public void push(int value) {
        if (!overflow()) {
            stack[++top] = value;
            System.out.println("Pushed: " + value);
        } else {
            System.out.println("Stack Overflow! Cannot push " + value);
        }
    }

    @Override
    public int pop() {
        if (!underflow()) {
            int val = stack[top--];
            System.out.println("Popped: " + val);
            return val;
        } else {
            System.out.println("Stack Underflow! Cannot pop");
            return -1;
        }
    }

    @Override
    public void display() {
        if (underflow()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Stack elements:");
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    @Override
    public boolean overflow() {
        return top >= size - 1;
    }

    @Override
    public boolean underflow() {
        return top < 0;
    }
}

public class StackTest {
    public static void main(String[] args) {
        IntegerStack stack = new IntegerStack();
        Scanner scanner = new Scanner(System.in);
        int choice, value;

        do {
            System.out.println("\n--- Stack Menu ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    value = scanner.nextInt();
                    stack.push(value);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.display();
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);

        scanner.close();
    }
}
