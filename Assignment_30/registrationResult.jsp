<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    private String escapeHtml(String value) {
        if (value == null) return "";
        return value.replace("&", "&amp;").replace("<", "&lt;")
                    .replace(">", "&gt;").replace("\"", "&quot;")
                    .replace("'", "&#39;");
    }
%>
<%
    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");
    String password = request.getParameter("password");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Result</title>
</head>
<body>
    <h2>Registration Details</h2>
    <p>Name: <%= escapeHtml(name) %></p>
    <p>Email: <%= escapeHtml(email) %></p>
    <p>Phone Number: <%= escapeHtml(phone) %></p>
    <p>Password: <%= escapeHtml(password) %></p>
    <a href="registration.jsp">Back to Registration</a>
</body>
</html> 