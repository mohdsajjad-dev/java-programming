/*  Develop an Employee Payroll System that accepts employee IDs, basic salary, and bonus
amounts from the user. Convert the entered values into wrapper objects and perform validation
operations to ensure valid salary values before calculating the net salary. */
public class EmpPay {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        // Taking employee details as String input from user
        System.out.print("Enter Employee ID: ");
        String empIdStr = sc.nextLine();
        System.out.print("Enter Basic Salary: ");
        String basicSalaryStr = sc.nextLine();
        System.out.print("Enter Bonus Amount: ");
        String bonusAmountStr = sc.nextLine();

        // Converting input Strings to wrapper objects (Integer, Double)
        Integer empId = Integer.valueOf(empIdStr);
        Double basicSalary = Double.valueOf(basicSalaryStr);
        Double bonusAmount = Double.valueOf(bonusAmountStr);

        // Validating salary values before proceeding with calculation
        if (basicSalary < 0 || bonusAmount < 0) {
            System.out.println("Error: Salary and bonus amounts must be non-negative.");
            return;
        }

        // Calculating net salary using wrapper objects
        Double netSalary = basicSalary + bonusAmount;

        // Displaying employee payroll details
        System.out.println("Employee ID: " + empId);
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("Bonus Amount: " + bonusAmount);
        System.out.println("Net Salary: " + netSalary);

        sc.close(); // closing scanner to avoid resource leak
    }
}
