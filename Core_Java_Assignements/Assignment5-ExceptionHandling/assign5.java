import java.util.Scanner;

// Custom Exception: NotEnoughMoneyException
class NotEnoughMoneyException extends Exception {
    NotEnoughMoneyException(String message) {
        super(message);
    }
}

// Interface: InfStk
interface InfStk {
    void push(int value);

    int pop();
}

// Class: Stack
class Stack implements InfStk {
    private final int maxSize = 5;
    private int top;
    private int[] stackArray;

    Stack() {
        stackArray = new int[maxSize];
        top = -1;
    }

    // Push method
    public void push(int value) {
        if (top < maxSize - 1) {
            stackArray[++top] = value;
            System.out.println("Pushed " + value + " onto the stack.");
        } else {
            System.out.println("Stack Overflow! Cannot push " + value);
        }
    }

    // Pop method
    public int pop() {
        if (top >= 0) {
            System.out.println("Popped " + stackArray[top] + " from the stack.");
            return stackArray[top--];
        } else {
            System.out.println("Stack Underflow! Cannot pop from an empty stack.");
            return -1;
        }
    }
}

// Class: Bank
class Bank {
    private double balance;

    Bank(double initialBalance) {
        balance = initialBalance;
    }

    // Deposit method
    void deposit(double amount) {
        System.out.println("Old Balance: " + balance);
        balance += amount;
        System.out.println("New Balance after depositing " + amount + ": " + balance);
    }

    // Withdraw method
    void withdraw(double amount) throws ArithmeticException, NotEnoughMoneyException {
        System.out.println("Old Balance: " + balance);
        if (amount > balance) {
            throw new ArithmeticException("Insufficient funds! Cannot withdraw " + amount);
        }
        balance -= amount;
        if (balance < 500) {
            throw new NotEnoughMoneyException("Balance is less than 500 after withdrawing " + amount);
        }
        System.out.println("New Balance after withdrawing " + amount + ": " + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        // Program 1
        Scanner scanner = new Scanner(System.in);
        double result = 0;

        while (true) {
            try {
                System.out.print("Enter the first number: ");
                double num1 = Double.parseDouble(scanner.nextLine());

                System.out.print("Enter the second number: ");
                double num2 = Double.parseDouble(scanner.nextLine());

                result = num1 / num2;
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter valid numbers.");
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero! Please enter a non-zero second number.");
            }
        }

        System.out.println("Result of division: " + result);

        // Program 2
        try {
            if (args.length != 2) {
                throw new IllegalArgumentException("Two arguments are required!");
            }

            int arg1 = Integer.parseInt(args[0]);
            int arg2 = Integer.parseInt(args[1]);

            if (arg1 < 0 || arg2 < 0) {
                throw new IllegalArgumentException("Arguments cannot be negative!");
            }

            int divisionResult = arg1 / arg2;
            System.out.println("Result of division: " + divisionResult);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter valid integers.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Program 3
        try {
            System.out.print("Enter the fully qualified name of a class: ");
            String className = scanner.nextLine();
            Class<?> clazz = Class.forName(className);

            int superClassesCount = 0;
            while (clazz.getSuperclass() != null) {
                clazz = clazz.getSuperclass();
                superClassesCount++;
            }

            System.out.println("Number of super classes: " + superClassesCount);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found! Please enter a valid class name.");
        }

        // Program 4
        try {
            System.out.print("Enter a date (dd-MM-yyyy): ");
            String dateString = scanner.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            sdf.setLenient(false);
            sdf.parse(dateString);
            System.out.println("Entered date is valid.");
        } catch (Exception e) {
            System.out.println("Entered date is not valid! " + e.getMessage());
        }

        // Program 5
        try {
            System.out.print("Enter a time in 24-hour format (HH:mm): ");
            String timeString = scanner.nextLine();
            String[] timeParts = timeString.split(":");
            int hours = Integer.parseInt(timeParts[0]);
            int minutes = Integer.parseInt(timeParts[1]);

            if (hours < 0 || hours >= 24 || minutes < 0 || minutes >= 60) {
                throw new Exception("Invalid time!");
            }

            System.out.println("Entered time is valid.");
        } catch (Exception e) {
            System.out.println("Entered time is not valid! " + e.getMessage());
        }

        // Program 6
        try {
            int correctAnswers = 45;
            int totalQuestions = 50;
            calculatePercentage(correctAnswers, totalQuestions);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Program 7
        try {
            throw new Exception("Exception thrown inside try block.");
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed.");
        }

        // Program 8
        try {
            System.out.print("Enter the first double value: ");
            double num1 = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter the second double value: ");
            double num2 = Double.parseDouble(scanner.nextLine());

            double resultDouble = num1 / num2;
            System.out.println("Result of division: " + resultDouble);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter valid double values.");
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero! Please enter a non-zero second number.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        // Program 9
        try {
            Stack stack = new Stack();
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Program 10
        try {
            Bank bank = new Bank(1000);
            bank.deposit(500);
            bank.withdraw(200);
            bank.withdraw(800);
        } catch (ArithmeticException | NotEnoughMoneyException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    // Method to calculate percentage and check if the student passes the exam
    private static void calculatePercentage(int correctAnswers, int totalQuestions) throws Exception {
        if (totalQuestions <= 0) {
            throw new Exception("Total questions must be greater than zero.");
        }

        double percentage = (double) correctAnswers / totalQuestions * 100;
        System.out.println("Percentage: " + percentage);

        if (percentage > 40) {
            System.out.println("Student passes the exam.");
        } else {
            System.out.println("Student fails the exam.");
        }
    }
}
