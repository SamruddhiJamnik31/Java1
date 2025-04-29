import java.io.*;
import java.util.Scanner;

public class StudentInfoIO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        System.out.print("Enter weight (in kg): ");
        float weight = scanner.nextFloat();

        System.out.print("Enter height (in cm): ");
        float height = scanner.nextFloat();

        scanner.nextLine(); 

        System.out.print("Enter city: ");
        String city = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();

        
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("studentInfo.dat"))) {
            dos.writeUTF(name);
            dos.writeInt(age);
            dos.writeFloat(weight);
            dos.writeFloat(height);
            dos.writeUTF(city);
            dos.writeUTF(phone);
            System.out.println("\n Student information saved successfully to 'studentInfo.dat'.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        
        try (DataInputStream dis = new DataInputStream(new FileInputStream("studentInfo.dat"))) {
            System.out.println("\n Retrieved Student Information:");
            System.out.println("Name: " + dis.readUTF());
            System.out.println("Age: " + dis.readInt());
            System.out.println("Weight: " + dis.readFloat() + " kg");
            System.out.println("Height: " + dis.readFloat() + " cm");
            System.out.println("City: " + dis.readUTF());
            System.out.println("Phone Number: " + dis.readUTF());
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }

        scanner.close();
    }
}
