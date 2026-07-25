class StudentInfo {
    String name;
    int rollno;
    String course;
    int age;

    // Default Constructor: Initializes with default values
    StudentInfo() {
        System.out.println("-----Inside the Default Constructor-----");
        name = "Unknown";
        rollno = 0;
        course = "Not Assigned";
        age = 0;
    }

    // Parameterized Constructor: Initializes with specific values
    StudentInfo(String n, int r, String c, int a) {
        System.out.println("-----Inside the Parameterized Constructor-----");
        this.name = n;
        this.rollno = r;
        this.course = c;
        this.age = a;
    }

    // Method to display student details
    void display() {
        System.out.println("Name: " + name +
                           "\nRoll No: " + rollno +
                           "\nCourse: " + course +
                           "\nAge: " + age);
    }

    public static void main(String[] args) {
        // 1. Creating an object using the Default Constructor
        StudentInfo s1 = new StudentInfo();
        s1.display();

        // 2. Creating an object using the Parameterized Constructor
        StudentInfo s2 = new StudentInfo("Sajjad", 234, "B.Tech CSE", 19);
        s2.display();
    }
}