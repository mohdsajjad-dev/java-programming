import java.util.Scanner;

public class BankTransaction {

    public static void verifyWithdrawal() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter withdrawal amount: ");
            double withdrawal = scanner.nextDouble();

            if (withdrawal <= 0) {
                throw new IllegalArgumentException(
                    "Withdrawal amount must be greater than zero."
                );
            }

            System.out.println("Withdrawal successful.");
            System.out.println("Amount withdrawn: Rs. " + withdrawal);

        } catch (IllegalArgumentException exception) {
            System.out.println("Transaction Error: "
                    + exception.getMessage());

        } catch (Exception exception) {
            System.out.println("Invalid input. Please enter a valid amount.");
        }

        scanner.close();
    }

    public static void main(String[] args) {
        verifyWithdrawal();
    }
}