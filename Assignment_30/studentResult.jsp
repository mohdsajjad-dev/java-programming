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
    String prn = request.getParameter("prn");
    String course = request.getParameter("course");
    String semester = request.getParameter("semester");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Details</title>
</head>
<body>
    <h2>Student Information</h2>
    <p>Name: <%= escapeHtml(name) %></p>
    <p>PRN: <%= escapeHtml(prn) %></p>
    <p>Course: <%= escapeHtml(course) %></p>
    <p>Semester: <%= escapeHtml(semester) %></p>
    <a href="studentForm.jsp">Back</a>
</body>
</html>
