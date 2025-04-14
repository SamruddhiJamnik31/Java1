// Abstract class Shape
abstract class Shape {
    // Instance variables for the dimensions
    protected double dim1;
    protected double dim2;

    // Constructor to initialize the dimensions
    public Shape(double dim1, double dim2) {
        this.dim1 = dim1;
        this.dim2 = dim2;
    }

    // Abstract method to calculate the area of the shape
    public abstract double area();
}

// Rectangle class inheriting from Shape
class Rectangle extends Shape {
    // Constructor to initialize the dimensions of the rectangle
    public Rectangle(double length, double width) {
        super(length, width); // Call the constructor of Shape class
    }

    // Implementing the area() method for Rectangle
    @Override
    public double area() {
        return dim1 * dim2; // Area of rectangle: length * width
    }
}

// Triangle class inheriting from Shape
class Triangle extends Shape {
    // Constructor to initialize the dimensions of the triangle
    public Triangle(double base, double height) {
        super(base, height); // Call the constructor of Shape class
    }

    // Implementing the area() method for Triangle
    @Override
    public double area() {
        return 0.5 * dim1 * dim2; // Area of triangle: 0.5 * base * height
    }
}

// Main class to test the program
public class ShapeTest {
    public static void main(String[] args) {
        // Create a Rectangle object
        Shape rectangle = new Rectangle(10, 5);
        System.out.println("Area of Rectangle: " + rectangle.area());

        // Create a Triangle object
        Shape triangle = new Triangle(8, 4);
        System.out.println("Area of Triangle: " + triangle.area());
    }
}
