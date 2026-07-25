import java.util.Scanner;

public class Calculator {
    static int cal_count = 0; // static variable to track total add operations across all objects

    // Default Constructor
    Calculator() {
        System.out.println("Calculator object created (default).");
    }

    // Parameterized Constructor
    Calculator(int a, int b) {
        System.out.println("Calculator object created with integers: " + a + ", " + b);
    }

    // Overloaded method: adds two integers
    int add(int a, int b) {
        cal_count++;
        return a + b;
    }

    // Overloaded method: adds two decimal numbers
    double add(double a, double b) {
        cal_count++;
        return a + b;
    }

    // Takes user input and displays results of both overloaded add() methods
    void display(Scanner scanner) {
        System.out.print("Enter first integer: ");
        int int1 = scanner.nextInt();

        System.out.print("Enter second integer: ");
        int int2 = scanner.nextInt();

        int intResult = add(int1, int2);
        System.out.println("Result (Integers): " + int1 + " + " + int2 + " = " + intResult);

        System.out.print("Enter first decimal number: ");
        double double1 = scanner.nextDouble();

        System.out.print("Enter second decimal number: ");
        double double2 = scanner.nextDouble();

        double doubleResult = add(double1, double2);
        System.out.println("Result (Decimals): " + double1 + " + " + double2 + " = " + doubleResult);

        System.out.println("Total operations performed so far: " + cal_count);
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Creating object using Default Constructor
        Calculator obj1 = new Calculator();
        obj1.display(scanner);

        // 2. Creating object using Parameterized Constructor
        Calculator obj2 = new Calculator(13, 14);
        obj2.display(scanner);

        // Displaying total operations using static variable (shared across objects)
        System.out.println("Final global count: " + Calculator.cal_count);

        scanner.close();
    }
}