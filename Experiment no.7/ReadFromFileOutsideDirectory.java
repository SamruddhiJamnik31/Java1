import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFileOutsideDirectory {
    public static void main(String[] args) {
        String filePath = "sample.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            System.out.println("Reading from file: " + filePath);
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.err.println("An error occurred while reading the file:");
            e.printStackTrace();
        }
    }
}
