import java.util.Scanner;

class Vehicle {
    private String name = "Car";
    private int speed = 120;

    class Details {

        void display() {
            System.out.println("Vehicle Name : " + name);
            System.out.println("Vehicle Speed: " + speed + " km/h");

            mileageCalculator();
            travelTimeCalculator();
        }

        // Mileage Calculator
        void mileageCalculator() {
            Scanner sc = new Scanner(System.in);

            System.out.print("\nEnter distance travelled (km): ");
            double distance = sc.nextDouble();

            System.out.print("Enter fuel consumed (litres): ");
            double fuel = sc.nextDouble();

            double mileage = distance / fuel;

            System.out.printf("Mileage = %.2f km/l%n", mileage);
        }

        // Travel Time Calculator
        void travelTimeCalculator() {
            Scanner sc = new Scanner(System.in);

            System.out.print("\nEnter distance for trip (km): ");
            double distance = sc.nextDouble();

            double time = distance / speed;

            System.out.printf("Estimated Travel Time = %.2f hours%n", time);
        }
    }

    // Method for Anonymous Class
    void action() {
        System.out.println("Vehicle is moving.");
    }
}

public class VehicleProgram {

    public static void main(String[] args) {

        // Inner Class
        Vehicle v = new Vehicle();
        Vehicle.Details d = v.new Details();
        d.display();

        // Anonymous Class
        Vehicle obj = new Vehicle() {
            void action() {
                System.out.println("\nAnonymous Class:");
                System.out.println("Car is accelerating...");
                System.out.println("Current Status: Journey Started Successfully!");
            }
        };

        obj.action();
    }
}