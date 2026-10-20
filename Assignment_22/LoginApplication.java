
import java.sql.*;
import java.util.Scanner;

public class LoginApplication {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/company",
                "root",
                "Mohdsajjad#07"
            );

            System.out.print("Enter Username: ");
            String username = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            String query = "SELECT * FROM login WHERE username = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Login Successful!");
                System.out.println("Welcome, " + username);
            } else {
                System.out.println("Invalid Username or Password!");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
