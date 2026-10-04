import java.sql.*;

public class StudentRecords {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/CollegeDB";
        String username = "root";
        String password = "Mohdsajjad#07";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM StudentDetails");

            System.out.println("==============================================================");
            System.out.println("                    STUDENT DETAILS");
            System.out.println("==============================================================");
            System.out.printf("%-10s %-20s %-6s %-25s %-6s%n",
                    "ID", "NAME", "AGE", "COURSE", "MARKS");
            System.out.println("--------------------------------------------------------------");

            while (rs.next()) {
                System.out.printf("%-10d %-20s %-6d %-25s %-6d%n",
                        rs.getInt("StudentID"),
                        rs.getString("StudentName"),
                        rs.getInt("Age"),
                        rs.getString("Course"),
                        rs.getInt("Marks"));
            }

            System.out.println("==============================================================");

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}