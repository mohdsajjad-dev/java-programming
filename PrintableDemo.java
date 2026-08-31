interface Printable {
    void printDetails();
}

class Student implements Printable {
    public void printDetails() {
        System.out.println("Student Name: Rahul");
        System.out.println("Course: BCA");
    }
}

class Employee implements Printable {
    public void printDetails() {
        System.out.println("Employee Name: Amit");
        System.out.println("Department: IT");
    }
}

public class PrintableDemo {
    public static void main(String[] args) {
        Printable student = new Student();
        Printable employee = new Employee();
        System.out.println("--- Student Details ---");
        student.printDetails();
        System.out.println();
        System.out.println("--- Employee Details ---");
        employee.printDetails();
    }
}