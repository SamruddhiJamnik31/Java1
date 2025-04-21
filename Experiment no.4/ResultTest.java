import java.util.Scanner;

interface Sports {
    int sMarks = 20;
    void setSportsMarks(); 
}

class Student {
    private int rollNo;

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public int getRollNo() {
        return rollNo;
    }
}

class Test extends Student {
    private int sub1;
    private int sub2;

    public void setMarks(int sub1, int sub2) {
        this.sub1 = sub1;
        this.sub2 = sub2;
    }

    public int getSub1() {
        return sub1;
    }

    public int getSub2() {
        return sub2;
    }
}

class Result extends Test implements Sports {
    private int sportsMarks;

    @Override
    public void setSportsMarks() {
        this.sportsMarks = sMarks;
    }

    public void displayResult() {
        int total = getSub1() + getSub2() + sportsMarks;
        System.out.println("\n--- Student Result ---");
        System.out.println("Roll No: " + getRollNo());
        System.out.println("Subject 1 Marks: " + getSub1());
        System.out.println("Subject 2 Marks: " + getSub2());
        System.out.println("Sports Marks: " + sportsMarks);
        System.out.println("Total Marks: " + total);
    }
}

public class ResultTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Result student = new Result();

        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();
        student.setRollNo(roll);

        System.out.print("Enter Marks for Subject 1: ");
        int s1 = sc.nextInt();

        System.out.print("Enter Marks for Subject 2: ");
        int s2 = sc.nextInt();

        student.setMarks(s1, s2);
        student.setSportsMarks();

        student.displayResult();
        sc.close();
    }
}
