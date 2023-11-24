class Person {
    String name;
    int age;
    float salary;

    // Constructor with parameters
    Person(String n, int a, float s) {
        name = n;
        age = a;
        salary = s;
    }

    // Display method
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
    }
}

class Circle {
    double radius;
    double x, y; // Coordinates of the center

    // Constructor with radius argument (assuming circle centered at the origin)
    Circle(double r) {
        radius = r;
    }

    // Constructor with center coordinates and radius arguments
    Circle(double centerX, double centerY, double r) {
        x = centerX;
        y = centerY;
        radius = r;
    }

    // Method to calculate the area of the circle
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Stack {
    private int top;
    private int maxSize;
    private int[] stackArray;

    public Stack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int value) {
        if (top < maxSize - 1) {
            stackArray[++top] = value;
            System.out.println(value + " pushed into the stack");
        } else {
            System.out.println("Stack is full. Cannot push " + value);
        }
    }

    public void pop() {
        if (top >= 0) {
            System.out.println(stackArray[top--] + " popped from the stack");
        } else {
            System.out.println("Stack is empty. Cannot pop");
        }
    }
}

class Point3D {
    double x, y, z;

    // Constructors
    public Point3D(double arg1) {
        x = y = z = arg1;
    }

    public Point3D(double arg1, double arg2) {
        x = arg1;
        y = arg2;
        z = 0;
    }

    public Point3D(double arg1, double arg2, double arg3) {
        x = arg1;
        y = arg2;
        z = arg3;
    }

    // Display method
    public void display() {
        System.out.println("x: " + x + ", y: " + y + ", z: " + z);
    }
}

public class Main {
    public static void main(String[] args) {
        // Program 1: Person Class
        Person person = new Person("John Doe", 25, 50000.0f);
        System.out.println("Program 1: Person Class");
        person.display();

        // Program 2: Circle Class
        Circle circle1 = new Circle(5.0); // Circle centered at the origin
        Circle circle2 = new Circle(3.0, 4.0, 6.0); // Circle with center coordinates
        System.out.println("\nProgram 2: Circle Class");
        System.out.println("Area of Circle 1: " + circle1.calculateArea());
        System.out.println("Area of Circle 2: " + circle2.calculateArea());

        // Program 3: Stack Class
        Stack stack = new Stack(5);
        System.out.println("\nProgram 3: Stack Class");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.pop();
        stack.pop();

        // Program 4: Point3D Class
        Point3D point1 = new Point3D(2.0);
        Point3D point2 = new Point3D(3.0, 4.0);
        Point3D point3 = new Point3D(5.0, 6.0, 7.0);
        System.out.println("\nProgram 4: Point3D Class");
        point1.display();
        point2.display();
        point3.display();
    }
}
