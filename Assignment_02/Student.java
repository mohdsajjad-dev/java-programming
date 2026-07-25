class Student {
    String name;
    int age;
    int rollno;
    float weight;
    float height;

    // Default Constructor: Initializes with default values
    Student() {
        System.out.println("-----Inside the Default Constructor-----");
        name = "Unknown";
        age = 0;
        rollno = 0;
        weight = 0.0f;
        height = 0.0f;
    }

    // Parameterized Constructor: Initializes with specific values
    Student(String n, int a, int r, float w, float h) {
        System.out.println("-----Inside the Parameterized Constructor-----");
        this.name = n;
        this.age = a;
        this.rollno = r;
        this.weight = w;
        this.height = h;
    }

    // Copy Constructor: Initializes using an existing Student object
    Student(Student s1) {
        System.out.println("-----Inside the Copy Constructor-----");
        this.name = s1.name;
        this.age = s1.age;
        this.rollno = s1.rollno;
        this.weight = s1.weight;
        this.height = s1.height;
    }

    // Method to display student details
    void display() {
        System.out.println("Name: " + name +
                           "\nAge: " + age +
                           "\nRoll No: " + rollno +
                           "\nWeight: " + weight + "kg" +
                           "\nHeight: " + height + "cm");
    }

    public static void main(String[] args) {
        // 1. Creating an object using the Default Constructor
        Student s0 = new Student();
        s0.display();

        // 2. Creating an object using the Parameterized Constructor
        Student s1 = new Student("Sajjad", 19, 234, 72.5f, 175.5f);
        s1.display();

        // 3. Creating an object using the Copy Constructor
        Student s2 = new Student(s1);
        s2.display();

        // 4. Demonstration of Comparison Operators
        int x = 10;
        int y = 20;
        System.out.println("Is y greater than or equal to x? " + (y >= x));
    }
}
