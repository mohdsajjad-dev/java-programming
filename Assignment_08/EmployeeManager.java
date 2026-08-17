class Employee {
    String name;
    int empId;
    double salary;

    Employee(String name, int empId, double salary) {
        this.name = name;
        this.empId = empId;
        this.salary = salary;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + empId);
        System.out.println("Salary: " + salary);
    }
}

class Manager extends Employee {
    String department;

    Manager(String name, int empId, double salary, String department) {
        super(name, empId, salary);
        this.department = department;
    }

    void display() {
        super.display();
        System.out.println("Department: " + department);
    }
}

public class EmployeeManager {
    public static void main(String[] args) {
        Manager m = new Manager("Rahul", 101, 75000, "HR");
        m.display();
    }
}
