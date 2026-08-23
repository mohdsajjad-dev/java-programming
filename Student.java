package studentpackage;

public class Student {
    private int rollNo;
    private String name;
    private String course;
    private double percentage;

    public Student(int rollNo, String name, String course, double percentage) {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
        this.percentage = percentage;
    }

    public void displayStudentInfo() {
        System.out.println("----- Student Details -----");
        System.out.println("Roll No    : " + rollNo);
        System.out.println("Name       : " + name);
        System.out.println("Course     : " + course);
        System.out.println("Percentage : " + percentage + "%");
    }
}