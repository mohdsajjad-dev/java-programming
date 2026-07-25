class MethodOverloadingStatic {
    static int count; // static variable shared across all objects
    int a = 0;

    // Default Constructor: initializes 'a' with a fixed value
    MethodOverloadingStatic() {
        a = 1;
        count++;
    }

    // Parameterized Constructor: initializes 'a' with user-given value
    MethodOverloadingStatic(int b) {
        a = b;
        count++;
    }

    // Overloaded method: displays 'a' and static count (no parameters)
    void show() {
        System.out.println("a: " + a);
        System.out.println("Count: " + MethodOverloadingStatic.count);
    }

    // Overloaded method: displays 'a' along with a passed parameter 'c'
    void show(int c) {
        System.out.println("Inside parameterized show: ");
        System.out.println("a: " + a);
        System.out.println("c: " + c);
    }

    public static void main(String[] args) {
        // 1. Creating object using Default Constructor
        MethodOverloadingStatic o1 = new MethodOverloadingStatic();
        o1.show();
        o1.show(100);

        // 2. Creating object using Parameterized Constructor
        MethodOverloadingStatic o2 = new MethodOverloadingStatic(5);
        o2.show(122);

        // 3. Demonstrating static variable shared across objects
        System.out.println("Total Objects Created (Count): " + MethodOverloadingStatic.count);
    }
}