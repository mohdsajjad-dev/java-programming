import java.sql.*;

public class EmployeeRecords {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/company", "root", "Mohdsajjad#07");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                "SELECT emp_id, name, department, salary FROM employee");

            while (rs.next()) {
                System.out.println("Employee ID: " + rs.getInt("emp_id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Department: " + rs.getString("department"));
                System.out.println("Salary: " + rs.getDouble("salary"));
                System.out.println("----------------------");
            }

            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}