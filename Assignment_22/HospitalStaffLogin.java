
import java.sql.*;
import java.util.Scanner;

public class HospitalStaffLogin {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/company",
                "root",
                "Mohdsajjad#07"
            );

            System.out.print("Enter Login ID: ");
            String loginId = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            String query = "SELECT role FROM hospital_staff WHERE login_id = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, loginId);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String role = rs.getString("role");

                System.out.println("Authentication Successful!");

                if (role.equalsIgnoreCase("Doctor")) {
                    System.out.println("Welcome Doctor! Access Granted.");
                } else if (role.equalsIgnoreCase("Nurse")) {
                    System.out.println("Welcome Nurse! Access Granted.");
                } else {
                    System.out.println("Access Denied!");
                }
            } else {
                System.out.println("Invalid Login ID or Password!");
                System.out.println("Access Denied!");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
