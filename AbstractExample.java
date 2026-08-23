abstract class Shape {
    abstract void draw();

    void message() {
        System.out.println("This is a concrete method in the abstract class.");
    }
}

class Circle extends Shape {
    void draw() {
        System.out.println("Drawing a Circle.");
    }
}   

public class AbstractExample {
    public static void main(String[] args) {
        Shape shape = new Circle();
        shape.draw(); // Calls the draw method of Circle
        shape.message(); // Calls the concrete method from Shape
    }
}
