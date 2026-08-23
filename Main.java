import MySqpackage.Square;
import Mypackage.Rectangle;

public class Main {
    public static void main(String[] args) {
        Square square = new Square();
        int area = square.displayArea(5);
        System.out.println("Area of the square is: " + area);

	Rectangle rectangle = new Rectangle();
	int area1 = rectangle.showArea(5, 7);
	System.out.println("Area of the rectangle is: "+area1);
    }
}