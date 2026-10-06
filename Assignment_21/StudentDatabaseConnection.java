import java.sql.*;

public class StudentDatabaseConnection {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/StudentDB";
        String username = "root";
        String password = "Mohdsajjad#07";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("Student database connected successfully.");
            System.out.println("Connection Status: Connected");

            Statement stmt = con.createStatement();

            con.close();

        } catch (Exception e) {
            System.out.println("Connection Status: Failed");
            System.out.println("Error: " + e.getMessage());
        }
    }
}