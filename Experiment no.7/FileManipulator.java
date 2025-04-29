import java.io.*;
import java.util.Scanner;

public class FileManipulator {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java FileManipulator <file-name>");
            return;
        }

        String fileName = args[0];
        File file = new File(fileName);

        try {
         
            if (file.exists()) {
                System.out.println("File exists. Here are its contents:");
                displayFileContents(file);

                System.out.print("Do you want to add data to the end of the file? (Yes/No): ");
                Scanner scanner = new Scanner(System.in);
                String response = scanner.nextLine();

                if (response.equalsIgnoreCase("Yes")) {
                    appendDataToFile(file);
                } else {
                    System.out.println("No data will be added.");
                }
            } else {
                System.out.println("File does not exist. Creating a new file.");
                createAndWriteToFile(file);
            }

        } catch (IOException e) {
            System.err.println("Error handling the file: " + e.getMessage());
        }
    }
    private static void displayFileContents(File file) throws IOException {
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    private static void appendDataToFile(File file) throws IOException {
        Scanner scanner = new Scanner(System.in);
        try (FileWriter fw = new FileWriter(file, true); 
             BufferedWriter bw = new BufferedWriter(fw)) {
            String userInput;
            System.out.println("Enter data to append (type 'exit' to stop):");
            while (true) {
                userInput = scanner.nextLine();
                if (userInput.equalsIgnoreCase("exit")) {
                    break;
                }
                bw.write(userInput);
                bw.newLine();
            }
            System.out.println("Data appended successfully.");
        }
    }
    private static void createAndWriteToFile(File file) throws IOException {
        Scanner scanner = new Scanner(System.in);
        try (FileWriter fw = new FileWriter(file);
             BufferedWriter bw = new BufferedWriter(fw)) {
            System.out.println("Enter data to store in the new file (type 'exit' to stop):");
            String userInput;
            while (true) {
                userInput = scanner.nextLine();
                if (userInput.equalsIgnoreCase("exit")) {
                    break;
                }
                bw.write(userInput);
                bw.newLine();
            }
            System.out.println("Data written to the new file successfully.");
        }
    }
}
