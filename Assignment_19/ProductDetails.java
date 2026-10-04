import java.sql.*;

public class ProductDetails {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/ProductDB";
        String username = "root";
        String password = "Mohdsajjad#07";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM Products");

            System.out.println("==============================================================");
            System.out.println("                    PRODUCT DETAILS");
            System.out.println("==============================================================");
            System.out.printf("%-12s %-20s %-10s %-12s%n",
                    "PRODUCT ID", "PRODUCT NAME", "QUANTITY", "PRICE");
            System.out.println("--------------------------------------------------------------");

            while (rs.next()) {
                System.out.printf("%-12d %-20s %-10d Rs. %-8.2f%n",
                        rs.getInt("ProductID"),
                        rs.getString("ProductName"),
                        rs.getInt("Quantity"),
                        rs.getDouble("Price"));
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