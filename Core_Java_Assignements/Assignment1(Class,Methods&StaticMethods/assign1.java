import java.util.Scanner;
import java.util.Arrays;

class InformationPrinter {
    static void printInformation() {
        System.out.println("Name: Your Name");
        System.out.println("Age: Your Age");
        System.out.println("Address: Your Address");
        System.out.println("Contact Number: Your Contact Number");
    }
}

class Rectangle {
    static double calculateArea(double length, double breadth) {
        return length * breadth;
    }

    static double calculatePerimeter(double length, double breadth) {
        return 2 * (length + breadth);
    }
}

class Hardware {
    char choice;

    void showPrice() {
        switch (choice) {
            case 'F':
                System.out.println("Price of Floppy: 15 Rs.");
                break;
            case 'C':
                System.out.println("Price of CD: 20 Rs.");
                break;
            case 'P':
                System.out.println("Price of Pen drive: 1250 Rs.");
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
}

class NumberOperations {
    static boolean isPositive(int num) {
        return num > 0;
    }

    static boolean isEven(int num) {
        return num % 2 == 0;
    }

    static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    static boolean isPalindrome(int num) {
        int originalNum = num;
        int reversedNum = 0;
        while (num != 0) {
            int digit = num % 10;
            reversedNum = reversedNum * 10 + digit;
            num /= 10;
        }
        return originalNum == reversedNum;
    }

    static boolean isArmstrong(int num) {
        int originalNum = num;
        int numOfDigits = (int) Math.log10(num) + 1;
        int sum = 0;
        while (num != 0) {
            int digit = num % 10;
            sum += Math.pow(digit, numOfDigits);
            num /= 10;
        }
        return originalNum == sum;
    }

    static boolean isFibonacci(int num) {
        int a = 0, b = 1;
        while (a <= num) {
            if (a == num) {
                return true;
            }
            int temp = a + b;
            a = b;
            b = temp;
        }
        return false;
    }
}

class Demo {
    void test() {
        System.out.println("Test without parameters");
    }

    void test(int num) {
        System.out.println("Test with one integer parameter: " + num);
    }

    void test(int num1, int num2) {
        System.out.println("Test with two integer parameters: " + num1 + ", " + num2);
    }

    void test(double num) {
        System.out.println("Test with one double parameter: " + num);
    }
}

class Employee {
    int employeeNumber;
    String name;
    double basicSalary;

    void calculateNetSalary() {
        double MA = 100;
        double HRA = 300;
        double DA = 0.4 * basicSalary;
        double IT = 0.12 * basicSalary;
        double PF = 0.1 * basicSalary;

        double netSalary = basicSalary + HRA + DA - (PF + IT);
        System.out.println("Net Salary: " + netSalary);
    }
}

class Student {
    int rollNo;
    String name;
    int[] marks = new int[6];

    void calculateResult() {
        int total = Arrays.stream(marks).sum();
        double percentage = (double) total / (marks.length * 100) * 100;

        System.out.println("Total: " + total);
        System.out.println("Percentage: " + percentage + "%");

        if (marks.length == Arrays.stream(marks).filter(mark -> mark >= 40).count()) {
            System.out.println("Result: PASS");
        } else if (Arrays.stream(marks).filter(mark -> mark < 40).count() <= 2) {
            System.out.println("Result: ATKT");
        } else {
            System.out.println("Result: FAIL");
        }
    }
}

class ElectricityBoard {
    String[] names = new String[5];
    int[] unitsConsumed = new int[5];

    void calculateCharges() {
        double[] charges = new double[5];
        double additionalChargePercentage = 0.15;

        for (int i = 0; i < 5; i++) {
            if (unitsConsumed[i] <= 100) {
                charges[i] = unitsConsumed[i] * 0.6;
            } else if (unitsConsumed[i] <= 300) {
                charges[i] = 100 * 0.6 + (unitsConsumed[i] - 100) * 0.8;
            } else {
                charges[i] = 100 * 0.6 + 200 * 0.8 + (unitsConsumed[i] - 300) * 0.9;
            }

            if (charges[i] < 50) {
                charges[i] = 50;
            } else if (charges[i] > 300) {
                charges[i] += charges[i] * additionalChargePercentage;
            }
        }

        // Sort charges and corresponding names in ascending order
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4 - i; j++) {
                if (charges[j] > charges[j + 1]) {
                    // Swap charges
                    double tempCharge = charges[j];
                    charges[j] = charges[j + 1];
                    charges[j + 1] = tempCharge;

                    // Swap names
                    String tempName = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = tempName;
                }
            }
        }

        System.out.println("Names with Charges in Ascending Order:");
        for (int i = 0; i < 5; i++) {
            System.out.println(names[i] + ": " + charges[i] + " Rs.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Check for positive or negative number");
            System.out.println("2. Check for odd or even number");
            System.out.println("3. Check for primary number");
            System.out.println("4. Check for Palindrome number");
            System.out.println("5. Check for Armstrong number");
            System.out.println("6. Check for number whether a member of Fibonacci series");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a number: ");
                    int num1 = scanner.nextInt();
                    System.out.println("Positive: " + NumberOperations.isPositive(num1));
                    break;
                case 2:
                    System.out.print("Enter a number: ");
                    int num2 = scanner.nextInt();
                    System.out.println("Even: " + NumberOperations.isEven(num2));
                    break;
                case 3:
                    System.out.print("Enter a number: ");
                    int num3 = scanner.nextInt();
                    System.out.println("Prime: " + NumberOperations.isPrime(num3));
                    break;
                case 4:
                    System.out.print("Enter a number: ");
                    int num4 = scanner.nextInt();
                    System.out.println("Palindrome: " + NumberOperations.isPalindrome(num4));
                    break;
                case 5:
                    System.out.print("Enter a number: ");
                    int num5 = scanner.nextInt();
                    System.out.println("Armstrong: " + NumberOperations.isArmstrong(num5));
                    break;
                case 6:
                    System.out.print("Enter a number: ");
                    int num6 = scanner.nextInt();
                    System.out.println("Fibonacci: " + NumberOperations.isFibonacci(num6));
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number from 1 to 7.");
            }
        } while (choice != 7);
    }
}
