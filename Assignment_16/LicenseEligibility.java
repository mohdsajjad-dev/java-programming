import java.util.Scanner;

class LicenseAgeException extends Exception {
    public LicenseAgeException(String reason) {
        super(reason);
    }
}

public class LicenseEligibility {

    static void checkLicenseAge(int applicantAge)
            throws LicenseAgeException {

        if (applicantAge < 18) {
            throw new LicenseAgeException(
                "Applicant is not old enough to apply for a driving license."
            );
        }

        System.out.println(
            "The user is eligible for a driving license."
        );
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Enter applicant age: ");
            int ageValue = input.nextInt();

            checkLicenseAge(ageValue);

        } catch (LicenseAgeException ex) {
            System.out.println("License Error: " + ex.getMessage());

        } finally {
            System.out.println("License eligibility check completed.");
            input.close();
        }
    }
}