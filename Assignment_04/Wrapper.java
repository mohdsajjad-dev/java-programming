import java.util.Scanner;

public class Wrapper {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        String str1 = sc.nextLine();
        System.out.print("Enter the second number: ");
        String str2 = sc.nextLine();

        //String to Wrapper Object
        Integer num1 = Integer.valueOf(str1);
        Integer num2 = Integer.valueOf(str2);
        
        //Wrapper Object to Primitive (Unboxing)
        int a = num1;
        int b = num2;

        // Perform arithmetic operations
        System.out.println("The sum of the two numbers is: " + (a + b));
        System.out.println("The product of the two numbers is: " + (a * b));
        System.out.println("The difference of the two numbers is: " + (a - b));
        if (b != 0) {
            System.out.println("The quotient of the two numbers is: " + (double)a / b);
        } else {
            System.out.println("Cannot divide by zero.");
        }        

        //Primitive to Wrapper (Autoboxing)
        int x = 100;
        Integer wrapperX = x; // Autoboxing
        System.out.println("\nPrimitive to Wrapper: ");
        System.out.println("The value of x is: " + x);
        System.out.println("The value of wrapper object is: " + wrapperX);

        //Wrapper to Primitive
        Integer wrapperY = Integer.valueOf(200);
        int y = wrapperY;

        System.out.println("\nWrapper to Primitive: ");
        System.out.println("The value of wrapper object is: " + wrapperY);
        System.out.println("The value of y is: " + y);

        //Other wrapper methods
        System.out.println("\nOther Wrapper Methods: ");
        System.out.println("The maximum value of Integer is: " + Integer.max(a, b));
        System.out.println("The minimum value of Integer is: " + Integer.min(a, b));
        System.out.println("The sum of the two numbers is: " + Integer.sum(a, b));

        //close the scanner
        sc.close();
    }
}
