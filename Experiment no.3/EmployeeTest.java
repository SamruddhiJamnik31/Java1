// Base class Employee
class Employee {
    private String name;
    private String address;
    private double salary;
    private String jobTitle;

    // Constructor to initialize Employee properties
    public Employee(String name, String address, double salary, String jobTitle) {
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.jobTitle = jobTitle;
    }

    // Getter and Setter methods for the properties
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getSalary() {
        return salary;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    // Method to calculate bonus (base method)
    public double calculateBonus() {
        return salary * 0.10; // 10% bonus for all employees
    }

    // Method to generate performance report (base method)
    public void generatePerformanceReport() {
        System.out.println(name + "'s performance report: Excellent");
    }

    // Method to display employee details
    public void displayEmployeeDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Salary: $" + salary);
        System.out.println("Job Title: " + jobTitle);
    }
}

// Manager subclass (inherits from Employee)
class Manager extends Employee {
    private String department;

    // Constructor to initialize Manager properties
    public Manager(String name, String address, double salary, String jobTitle, String department) {
        super(name, address, salary, jobTitle);
        this.department = department;
    }

    // Overriding calculateBonus() method for Manager
    @Override
    public double calculateBonus() {
        return getSalary() * 0.15; // 15% bonus for managers
    }

    // Overriding performance report method for Manager
    @Override
    public void generatePerformanceReport() {
        System.out.println(getName() + " (Manager) Performance Report: Outstanding Leadership");
    }

    // Method to manage projects
    public void manageProject() {
        System.out.println(getName() + " is managing the department: " + department);
    }

    // Method to display Manager details (including department)
    @Override
    public void displayEmployeeDetails() {
        super.displayEmployeeDetails();
        System.out.println("Department: " + department);
    }
}

// Developer subclass (inherits from Employee)
class Developer extends Employee {
    private String programmingLanguage;

    // Constructor to initialize Developer properties
    public Developer(String name, String address, double salary, String jobTitle, String programmingLanguage) {
        super(name, address, salary, jobTitle);
        this.programmingLanguage = programmingLanguage;
    }

    // Overriding calculateBonus() method for Developer
    @Override
    public double calculateBonus() {
        return getSalary() * 0.12; // 12% bonus for developers
    }

    // Overriding performance report method for Developer
    @Override
    public void generatePerformanceReport() {
        System.out.println(getName() + " (Developer) Performance Report: Excellent Coding Skills");
    }

    // Method to work on a project
    public void workOnProject() {
        System.out.println(getName() + " is coding using " + programmingLanguage + " for the project.");
    }

    // Method to display Developer details (including programming language)
    @Override
    public void displayEmployeeDetails() {
        super.displayEmployeeDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

// Programmer subclass (inherits from Developer)
class Programmer extends Developer {
    private String framework;

    // Constructor to initialize Programmer properties
    public Programmer(String name, String address, double salary, String jobTitle, String programmingLanguage, String framework) {
        super(name, address, salary, jobTitle, programmingLanguage);
        this.framework = framework;
    }

    // Overriding calculateBonus() method for Programmer
    @Override
    public double calculateBonus() {
        return getSalary() * 0.14; // 14% bonus for programmers
    }

    // Overriding performance report method for Programmer
    @Override
    public void generatePerformanceReport() {
        System.out.println(getName() + " (Programmer) Performance Report: Exceptional Programming with " + framework);
    }

    // Method to work with framework
    public void workWithFramework() {
        System.out.println(getName() + " is using " + framework + " framework for development.");
    }

    // Method to display Programmer details (including framework)
    @Override
    public void displayEmployeeDetails() {
        super.displayEmployeeDetails();
        System.out.println("Framework: " + framework);
    }
}

// Main class to test the program
public class EmployeeTest {
    public static void main(String[] args) {
        // Creating objects for Manager, Developer, and Programmer
        Manager manager = new Manager("Alice", "1234 Elm St", 80000, "Manager", "IT");
        Developer developer = new Developer("Bob", "5678 Oak St", 70000, "Developer", "Java");
        Programmer programmer = new Programmer("Charlie", "9101 Pine St", 75000, "Programmer", "Java", "Spring");

        // Displaying employee details
        System.out.println("Manager Details:");
        manager.displayEmployeeDetails();
        System.out.println("Bonus: $" + manager.calculateBonus());
        manager.generatePerformanceReport();
        manager.manageProject();

        System.out.println("\nDeveloper Details:");
        developer.displayEmployeeDetails();
        System.out.println("Bonus: $" + developer.calculateBonus());
        developer.generatePerformanceReport();
        developer.workOnProject();

        System.out.println("\nProgrammer Details:");
        programmer.displayEmployeeDetails();
        System.out.println("Bonus: $" + programmer.calculateBonus());
        programmer.generatePerformanceReport();
        programmer.workWithFramework();
    }
}
