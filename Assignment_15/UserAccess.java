import java.util.Scanner;

class PasswordMismatchException extends Exception {
    public PasswordMismatchException(String details) {
        super(details);
    }
}

public class UserAccess {

    static void authenticateUser(String enteredPassword)
            throws PasswordMismatchException {

        final String storedPassword = "Nova#7842";

        if (!storedPassword.equals(enteredPassword)) {
            throw new PasswordMismatchException(
                "Password does not match the registered password."
            );
        }

        System.out.println("Welcome! Login completed successfully.");
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Enter your password: ");
            String passwordInput = input.nextLine();

            authenticateUser(passwordInput);

        } catch (PasswordMismatchException ex) {
            System.out.println("Access Denied: " + ex.getMessage());

        } finally {
            System.out.println("Login verification has been completed.");
            input.close();
        }
    }
}