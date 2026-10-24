
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
    List<Object[]> patients = new ArrayList<Object[]>();
    String url = "jdbc:mysql://localhost:3306/java_assignment30?useSSL=false&serverTimezone=UTC";
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = DriverManager.getConnection(url, "root", "Mohdsajjad#07")) {
            String action = request.getParameter("action");
            if ("add".equals(action)) {
                String sql = "INSERT INTO patients(name, age, disease, treatment_status) VALUES (?, ?, ?, ?)";
                try (PreparedStatement ps = con.prepareStatement(sql)) {
                    ps.setString(1, request.getParameter("name"));
                    ps.setInt(2, Integer.parseInt(request.getParameter("age")));
                    ps.setString(3, request.getParameter("disease"));
                    ps.setString(4, request.getParameter("status"));
                    ps.executeUpdate();
                    message = "Patient record added successfully.";
                }
            } else if ("update".equals(action)) {
                String sql = "UPDATE patients SET name=?, age=?, disease=?, treatment_status=? WHERE patient_id=?";
                try (PreparedStatement ps = con.prepareStatement(sql)) {
                    ps.setString(1, request.getParameter("name"));
                    ps.setInt(2, Integer.parseInt(request.getParameter("age")));
                    ps.setString(3, request.getParameter("disease"));
                    ps.setString(4, request.getParameter("status"));
                    ps.setInt(5, Integer.parseInt(request.getParameter("id")));
                    message = ps.executeUpdate() > 0 ? "Patient record updated successfully." : "Patient ID not found.";
                }
            } else if ("delete".equals(action)) {
                try (PreparedStatement ps = con.prepareStatement("DELETE FROM patients WHERE patient_id=?")) {
                    ps.setInt(1, Integer.parseInt(request.getParameter("id")));
                    message = ps.executeUpdate() > 0 ? "Patient record deleted successfully." : "Patient ID not found.";
                }
            }
            try (Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery("SELECT patient_id, name, age, disease, treatment_status FROM patients ORDER BY patient_id")) {
                while (rs.next()) {
                    patients.add(new Object[]{rs.getInt("patient_id"), rs.getString("name"),
                        rs.getInt("age"), rs.getString("disease"), rs.getString("treatment_status")});
                }
            }
        }
    } catch (Exception e) {
        message = "Database error: " + e.getMessage();
    }
%>
<!DOCTYPE html>
<html>
<head><title>Patient Management</title></head>
<body>
    <h2>Patient Record Management</h2>
    <p><%= esc(message) %></p>
    <h3>Add Patient</h3>
    <form method="post" action="patient.jsp">
        <input type="hidden" name="action" value="add">
        Name: <input name="name" required>
        Age: <input type="number" name="age" min="0" required>
        Disease: <input name="disease" required>
        Treatment Status: <input name="status" required>
        <button type="submit">Add</button>
    </form>
    <h3>Update Patient</h3>
    <form method="post" action="patient.jsp">
        <input type="hidden" name="action" value="update">
        Patient ID: <input type="number" name="id" min="1" required>
        Name: <input name="name" required>
        Age: <input type="number" name="age" min="0" required>
        Disease: <input name="disease" required>
        Treatment Status: <input name="status" required>
        <button type="submit">Update</button>
    </form>
    <h3>Patient Records</h3>
    <table border="1" cellpadding="6" cellspacing="0">
        <tr><th>Patient ID</th><th>Name</th><th>Age</th><th>Disease</th><th>Treatment Status</th><th>Action</th></tr>
        <% for (Object[] row : patients) { %>
        <tr>
            <td><%= row[0] %></td><td><%= esc(String.valueOf(row[1])) %></td>
            <td><%= row[2] %></td><td><%= esc(String.valueOf(row[3])) %></td>
            <td><%= esc(String.valueOf(row[4])) %></td>
            <td><form method="post" action="patient.jsp">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="id" value="<%= row[0] %>">
                <button type="submit">Delete</button>
            </form></td>
        </tr>
        <% } %>
    </table>
</body>
</html>