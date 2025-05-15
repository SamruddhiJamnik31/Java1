import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server started. Waiting for a client...");
        Socket socket = serverSocket.accept();
        System.out.println("Client connected.");

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        String clientMsg, serverMsg;
        while (true) {
            clientMsg = input.readLine();
            if (clientMsg.equalsIgnoreCase("exit")) break;
            System.out.println("Client: " + clientMsg);

            System.out.print("Server: ");
            serverMsg = keyboard.readLine();
            output.println(serverMsg);
        }

        socket.close();
        serverSocket.close();
        System.out.println("Server closed.");
    }
}
