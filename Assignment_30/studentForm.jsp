<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Information</title>
</head>
<body>
    <h2>Enter Student Information</h2>
    <form action="studentResult.jsp" method="post">
        Name: <input type="text" name="name" required><br><br>
        PRN: <input type="text" name="prn" required><br><br>
        Course: <input type="text" name="course" required><br><br>
        Semester: <input type="text" name="semester" required><br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
