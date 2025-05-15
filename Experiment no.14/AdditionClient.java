import java.io.*;
import java.net.*;
import java.util.Scanner;

public class AdditionClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 2345);
        Scanner scanner = new Scanner(System.in);
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

        output.writeInt(num1);
        output.writeInt(num2);

        int sum = input.readInt();
        System.out.println("Sum received from server: " + sum);

        socket.close();
        scanner.close();
    }
}
