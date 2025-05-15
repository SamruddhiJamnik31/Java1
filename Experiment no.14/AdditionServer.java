import java.io.*;
import java.net.*;

public class AdditionServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(2345);
        System.out.println("Addition Server is running...");
        Socket socket = serverSocket.accept();
        System.out.println("Client connected.");

        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        int num1 = input.readInt();
        int num2 = input.readInt();
        int sum = num1 + num2;

        output.writeInt(sum);

        socket.close();
        serverSocket.close();
        System.out.println("Server closed.");
    }
}
