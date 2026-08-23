import facultypackage.Faculty;
import studentpackage.Student;

public class CollegeApp {
    public static void main(String[] args) {
        Student s1 = new Student(101, "Aditya Sharma", "Computer Engineering", 87.5);
        s1.displayStudentInfo();

        System.out.println();

        Faculty f1 = new Faculty(501, "Dr. Priya Deshmukh", "Computer Engineering", "Object Oriented Programming");
        f1.displayFacultyInfo();
    }
}
