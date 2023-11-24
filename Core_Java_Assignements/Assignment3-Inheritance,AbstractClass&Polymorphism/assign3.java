import java.util.Arrays;

class M {
    float variableFloat;
    String variableString;

    M(float f, String s) {
        variableFloat = f;
        variableString = s;
    }
}

class N extends M {
    double variableDouble;

    N(float f, String s, double d) {
        super(f, s);
        variableDouble = d;
    }

    void displayVariables() {
        System.out.println("Float Variable: " + variableFloat);
        System.out.println("String Variable: " + variableString);
        System.out.println("Double Variable: " + variableDouble);
    }
}

class S {
    int X;

    S(int x) {
        X = x;
    }

    void displayX() {
        System.out.println("Class S - Integer X: " + X);
    }
}

class T extends S {
    String X;

    T(int x, String s) {
        super(x);
        X = s;
    }

    void displayX() {
        System.out.println("Class T - String X: " + X);
    }
}

abstract class Shape {
    double side1, side2;

    Shape(double s1, double s2) {
        side1 = s1;
        side2 = s2;
    }

    abstract void displayArea();
}

class Rectangle extends Shape {
    Rectangle(double l, double w) {
        super(l, w);
    }

    void displayArea() {
        System.out.println("Rectangle Area: " + (side1 * side2));
    }
}

class Circle extends Shape {
    double radius;

    Circle(double r) {
        super(r, 0);
        radius = r;
    }

    void displayArea() {
        System.out.println("Circle Area: " + (Math.PI * radius * radius));
    }
}

class NumberOperations {
    int[] numbers;

    NumberOperations(int[] nums) {
        numbers = nums;
    }

    void displayNumbers() {
        System.out.println("Numbers Entered: " + Arrays.toString(numbers));
    }

    void sumNumbers() {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        System.out.println("Sum of Numbers: " + sum);
    }

    void averageNumbers() {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        double average = (double) sum / numbers.length;
        System.out.println("Average of Numbers: " + average);
    }

    void maxNumber() {
        int max = Arrays.stream(numbers).max().orElseThrow();
        System.out.println("Maximum Number: " + max);
    }

    void minNumber() {
        int min = Arrays.stream(numbers).min().orElseThrow();
        System.out.println("Minimum Number: " + min);
    }
}

public class Main {
    public static void main(String[] args) {
        // Program 1: Class N instantiation and display
        N nObject = new N(10.5f, "Hello", 25.75);
        System.out.println("\nProgram 1: Class N Instantiation");
        nObject.displayVariables();

        // Program 2: Variable Hiding
        S sObject = new S(5);
        T tObject = new T(10, "World");
        System.out.println("\nProgram 2: Variable Hiding");
        sObject.displayX();
        tObject.displayX();

        // Program 3: Abstract Classes
        System.out.println("\nProgram 3: Abstract Classes");
        Shape rectangle = new Rectangle(4.0, 5.0);
        Shape circle = new Circle(3.0);
        rectangle.displayArea();
        circle.displayArea();

        // Program 4: Number Operations
        System.out.println("\nProgram 4: Number Operations");
        int[] numbersArray = {5, 8, 12, 3, 6, 10};
        NumberOperations numOps = new NumberOperations(numbersArray);
        numOps.displayNumbers();
        numOps.sumNumbers();
        numOps.averageNumbers();
        numOps.maxNumber();
        numOps.minNumber();
    }
}
