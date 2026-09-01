import java.util.Scanner;

class PinValidationException extends Exception {
    public PinValidationException(String reason) {
        super(reason);
    }
}

public class SecureATM {

    static void confirmPin(String enteredPin)
            throws PinValidationException {

        final String savedPin = "7391";

        if (!savedPin.equals(enteredPin)) {
            throw new PinValidationException(
                "The entered PIN is incorrect."
            );
        }

        System.out.println("PIN verified successfully.");
        System.out.println("ATM services are now available.");
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Enter 4-digit ATM PIN: ");
            String pinEntry = input.nextLine();

            confirmPin(pinEntry);

        } catch (PinValidationException ex) {
            System.out.println("PIN Error: " + ex.getMessage());

        } finally {
            System.out.println("PIN verification process has completed.");
            input.close();
        }
    }
}