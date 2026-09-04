import java.util.Scanner;

class VotingAgeException extends Exception {
    public VotingAgeException(String message) {
        super(message);
    }
}

public class ElectionCheck {

    static void verifyVoter(int voterAge)
            throws VotingAgeException {

        if (voterAge < 18) {
            throw new VotingAgeException(
                "Voter must be at least 18 years old."
            );
        }

        System.out.println("You are eligible to vote.");
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Enter your age: ");
            int ageInput = input.nextInt();

            verifyVoter(ageInput);

        } catch (VotingAgeException ex) {
            System.out.println("Voting Error: " + ex.getMessage());

        } finally {
            System.out.println("Voting eligibility check completed.");
            input.close();
        }
    }
}