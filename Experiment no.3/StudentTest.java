// Base class Student
class Student {
    // Instance variable for roll number
    protected int rollNo;

    // Constructor to initialize roll number
    public Student(int rollNo) {
        this.rollNo = rollNo;
    }

    // Method to display roll number
    public void displayRollNo() {
        System.out.println("Roll No: " + rollNo);
    }
}

// Derived class Test that inherits from Student
class Test extends Student {
    // Instance variables for two subjects
    protected double sub1, sub2;

    // Constructor to initialize roll number and marks of subjects
    public Test(int rollNo, double sub1, double sub2) {
        super(rollNo);  // Call the constructor of the Student class
        this.sub1 = sub1;
        this.sub2 = sub2;
    }

    // Method to display marks of the subjects
    public void displayMarks() {
        System.out.println("Marks in Subject 1: " + sub1);
        System.out.println("Marks in Subject 2: " + sub2);
    }
}

// Derived class Result that inherits from Test
class Result extends Test {
    // Constructor to initialize roll number, marks of subjects
    public Result(int rollNo, double sub1, double sub2) {
        super(rollNo, sub1, sub2);  // Call the constructor of Test class
    }

    // Method to calculate and display the total and percentage
    public void displayResult() {
        double total = sub1 + sub2;
        double percentage = (total / 200) * 100;
        System.out.println("Total Marks: " + total + "/200");
        System.out.println("Percentage: " + percentage + "%");

        // Display result based on percentage
        if (percentage >= 50) {
            System.out.println("Result: Passed");
        } else {
            System.out.println("Result: Failed");
        }
    }
}

// Main class to test the multilevel inheritance
public class StudentTest {
    public static void main(String[] args) {
        // Create a Result object
        Result student = new Result(100, 75.5, 80.0);
        
        // Display Roll No
        student.displayRollNo();
        
        // Display Marks
        student.displayMarks();
        
        // Display Result
        student.displayResult();
    }
}
