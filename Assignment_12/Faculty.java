package facultypackage;

public class Faculty {
    private int facultyId;
    private String name;
    private String department;
    private String subject;

    public Faculty(int facultyId, String name, String department, String subject) {
        this.facultyId = facultyId;
        this.name = name;
        this.department = department;
        this.subject = subject;
    }

    public void displayFacultyInfo() {
        System.out.println("----- Faculty Details -----");
        System.out.println("Faculty ID : " + facultyId);
        System.out.println("Name       : " + name);
        System.out.println("Department : " + department);
        System.out.println("Subject    : " + subject);
    }
}
