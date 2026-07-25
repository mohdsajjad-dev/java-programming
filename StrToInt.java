// 1. Create a program to convert student marks from String format to Integer and calculate total marks.
import java.util.Scanner;

public class StrToInt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking marks as String input (simulating form/text input)
        System.out.print("Enter marks for subject 1: ");
        String mark1 = sc.nextLine();
        System.out.print("Enter marks for subject 2: ");
        String mark2 = sc.nextLine();
        System.out.print("Enter marks for subject 3: ");
        String mark3 = sc.nextLine();
        System.out.print("Enter marks for subject 4: ");
        String mark4 = sc.nextLine();
        System.out.print("Enter marks for subject 5: ");
        String mark5 = sc.nextLine();

        // Converting String marks to Integer using wrapper class method
        int m1 = Integer.parseInt(mark1);
        int m2 = Integer.parseInt(mark2);
        int m3 = Integer.parseInt(mark3);
        int m4 = Integer.parseInt(mark4);
        int m5 = Integer.parseInt(mark5);

        // Calculating total marks after conversion
        int totalMarks = m1 + m2 + m3 + m4 + m5;

        // Displaying total and average marks
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Marks: " + (double) totalMarks / 5);

        sc.close(); // closing scanner to avoid resource leak
    }
}