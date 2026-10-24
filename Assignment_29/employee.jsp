<%@ page import="java.sql.*,java.util.*" contentType="text/html;charset=UTF-8" language="java" %>
<%!
    private String esc(String value) {
        if (value == null) return "";
        return value.replace("&", "&amp;").replace("<", "&lt;")
                    .replace(">", "&gt;").replace("\"", "&quot;")
                    .replace("'", "&#39;");
    }
%>
<%
    request.setCharacterEncoding("UTF-8");
    String message = "";
    List<Object[]> employees = new ArrayList<Object[]>();
    String url = "jdbc:mysql://localhost:3306/java_assignment30?useSSL=false&serverTimezone=UTC";
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = DriverManager.getConnection(url, "root", "Mohdsajjad#07")) {
            String action = request.getParameter("action");
            if ("add".equals(action)) {
                String sql = "INSERT INTO employees(name, department, salary) VALUES (?, ?, ?)";
                try (PreparedStatement ps = con.prepareStatement(sql)) {
                    ps.setString(1, request.getParameter("name"));
                    ps.setString(2, request.getParameter("department"));
                    ps.setBigDecimal(3, new java.math.BigDecimal(request.getParameter("salary")));
                    ps.executeUpdate();
                    message = "Employee added successfully.";
                }
            } else if ("update".equals(action)) {
                String sql = "UPDATE employees SET name=?, department=?, salary=? WHERE id=?";
                try (PreparedStatement ps = con.prepareStatement(sql)) {
                    ps.setString(1, request.getParameter("name"));
                    ps.setString(2, request.getParameter("department"));
                    ps.setBigDecimal(3, new java.math.BigDecimal(request.getParameter("salary")));
                    ps.setInt(4, Integer.parseInt(request.getParameter("id")));
                    message = ps.executeUpdate() > 0 ? "Employee updated successfully." : "Employee ID not found.";
                }
            } else if ("delete".equals(action)) {
                try (PreparedStatement ps = con.prepareStatement("DELETE FROM employees WHERE id=?")) {
                    ps.setInt(1, Integer.parseInt(request.getParameter("id")));
                    message = ps.executeUpdate() > 0 ? "Employee deleted successfully." : "Employee ID not found.";
                }
            }
            try (Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery("SELECT id, name, department, salary FROM employees ORDER BY id")) {
                while (rs.next()) {
                    employees.add(new Object[]{rs.getInt("id"), rs.getString("name"),
                        rs.getString("department"), rs.getBigDecimal("salary")});
                }
            }
        }
    } catch (Exception e) {
        message = "Database error: " + e.getMessage();
    }
%>
<!DOCTYPE html>
<html>
<head><title>Employee Management</title></head>
<body>
    <h2>Employee Management System</h2>
    <p><%= esc(message) %></p>
    <h3>Add Employee</h3>
    <form method="post" action="employee.jsp">
        <input type="hidden" name="action" value="add">
        Name: <input name="name" required>
        Department: <input name="department" required>
        Salary: <input type="number" name="salary" min="0" step="0.01" required>
        <button type="submit">Add</button>
    </form>
    <h3>Update Employee</h3>
    <form method="post" action="employee.jsp">
        <input type="hidden" name="action" value="update">
        Employee ID: <input type="number" name="id" min="1" required>
        Name: <input name="name" required>
        Department: <input name="department" required>
        Salary: <input type="number" name="salary" min="0" step="0.01" required>
        <button type="submit">Update</button>
    </form>
    <h3>Employee Records</h3>
    <table border="1" cellpadding="6" cellspacing="0">
        <tr><th>ID</th><th>Name</th><th>Department</th><th>Salary</th><th>Action</th></tr>
        <% for (Object[] row : employees) { %>
        <tr>
            <td><%= row[0] %></td><td><%= esc(String.valueOf(row[1])) %></td>
            <td><%= esc(String.valueOf(row[2])) %></td><td><%= row[3] %></td>
            <td><form method="post" action="employee.jsp">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="id" value="<%= row[0] %>">
                <button type="submit">Delete</button>
            </form></td>
        </tr>
        <% } %>
    </table>
</body>
</html>