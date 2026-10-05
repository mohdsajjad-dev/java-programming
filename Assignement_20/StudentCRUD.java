import java.sql.*;

public class StudentCRUD {

    static String url = "jdbc:mysql://localhost:3306/StudentDB";
    static String username = "root";
    static String password = "Mohdsajjad#07";

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);

            // INSERT
            String insertQuery =
                    "INSERT INTO StudentDetails VALUES (?, ?, ?, ?)";

            PreparedStatement insert = con.prepareStatement(insertQuery);

            insert.setInt(1, 104);
            insert.setString(2, "Rohan Patel");
            insert.setString(3, "Computer Science");
            insert.setInt(4, 82);

            insert.executeUpdate();
            System.out.println("Student inserted successfully.");

            // UPDATE
            String updateQuery =
                    "UPDATE StudentDetails SET Marks = ? WHERE RollNo = ?";

            PreparedStatement update = con.prepareStatement(updateQuery);

            update.setInt(1, 90);
            update.setInt(2, 104);

            update.executeUpdate();
            System.out.println("Student updated successfully.");

            // DELETE
            String deleteQuery =
                    "DELETE FROM StudentDetails WHERE RollNo = ?";

            PreparedStatement delete = con.prepareStatement(deleteQuery);

            delete.setInt(1, 103);

            delete.executeUpdate();
            System.out.println("Student deleted successfully.");

            // SELECT
            String selectQuery = "SELECT * FROM StudentDetails";

            PreparedStatement select = con.prepareStatement(selectQuery);

            ResultSet rs = select.executeQuery();

            System.out.println();
            System.out.println("==============================================================");
            System.out.println("                    STUDENT DETAILS");
            System.out.println("==============================================================");

            System.out.printf("%-10s %-20s %-25s %-8s%n",
                    "ROLL NO", "NAME", "COURSE", "MARKS");

            System.out.println("--------------------------------------------------------------");

            while (rs.next()) {
                System.out.printf("%-10d %-20s %-25s %-8d%n",
                        rs.getInt("RollNo"),
                        rs.getString("StudentName"),
                        rs.getString("Course"),
                        rs.getInt("Marks"));
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