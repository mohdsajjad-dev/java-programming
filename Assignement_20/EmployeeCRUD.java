import java.sql.*;

public class EmployeeCRUD {

    static String url = "jdbc:mysql://localhost:3306/EmployeeDB";
    static String username = "root";
    static String password = "Mohdsajjad#07";

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);

            // INSERT
            String insertQuery = "INSERT INTO EmployeeDetails VALUES (?, ?, ?, ?)";
            PreparedStatement insert = con.prepareStatement(insertQuery);

            insert.setInt(1, 104);
            insert.setString(2, "Rohan Patel");
            insert.setString(3, "Marketing");
            insert.setDouble(4, 52000.00);

            insert.executeUpdate();
            System.out.println("Employee inserted successfully.");

            // UPDATE
            String updateQuery =
                    "UPDATE EmployeeDetails SET Salary = ? WHERE EmployeeID = ?";

            PreparedStatement update = con.prepareStatement(updateQuery);

            update.setDouble(1, 58000.00);
            update.setInt(2, 104);

            update.executeUpdate();
            System.out.println("Employee updated successfully.");

            // DELETE
            String deleteQuery =
                    "DELETE FROM EmployeeDetails WHERE EmployeeID = ?";

            PreparedStatement delete = con.prepareStatement(deleteQuery);

            delete.setInt(1, 103);

            delete.executeUpdate();
            System.out.println("Employee deleted successfully.");

            // SELECT
            String selectQuery = "SELECT * FROM EmployeeDetails";

            PreparedStatement select = con.prepareStatement(selectQuery);

            ResultSet rs = select.executeQuery();

            System.out.println();
            System.out.println("==============================================================");
            System.out.println("                    EMPLOYEE DETAILS");
            System.out.println("==============================================================");

            System.out.printf("%-12s %-20s %-15s %-12s%n",
                    "ID", "NAME", "DEPARTMENT", "SALARY");

            System.out.println("--------------------------------------------------------------");

            while (rs.next()) {
                System.out.printf("%-12d %-20s %-15s Rs. %-10.2f%n",
                        rs.getInt("EmployeeID"),
                        rs.getString("EmployeeName"),
                        rs.getString("Department"),
                        rs.getDouble("Salary"));
            }

            System.out.println("==============================================================");

            rs.close();
            insert.close();
            update.close();
            delete.close();
            select.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}