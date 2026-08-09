class Shape {
    String color = "Blue";

    void display() {
        System.out.println("This is a " + color + " shape.");
    }
}

class Circle extends Shape {
    double radius = 5;

    void calculateArea() {
        double area = 3.14 * radius * radius;
        System.out.println("Area of Circle: " + area);
    }
}

class Rectangle extends Shape {
    double length = 10;
    double breadth = 5;

    void calculateArea() {
        double area = length * breadth;
        System.out.println("Area of Rectangle: " + area);
    }
}

public class ShapeApplication {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();

        circle.display();
        circle.calculateArea();

        rectangle.display();
        rectangle.calculateArea();
    }
}