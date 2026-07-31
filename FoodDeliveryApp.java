import java.util.Scanner;

public class FoodDeliveryApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Customer Name: ");
        String customer = sc.nextLine();

        System.out.print("Enter Food Item: ");
        String food = sc.nextLine();

        Restaurant r = new Restaurant(customer, food);

        // Demonstrating Inner Class
        Restaurant.Order o = r.new Order();
        o.display();

        // Demonstrating Anonymous Class
        DeliveryStatus d = new DeliveryStatus() {
            @Override
            void updateStatus() {
                System.out.println("Delivery Status: Order Delivered Successfully.");
            }
        };

        d.updateStatus();
    }
}

// Outer Class
class Restaurant {

    private String customer;
    private String food;

    Restaurant(String customer, String food) {
        this.customer = customer;
        this.food = food;
    }

    // Inner Class
    class Order {

        void display() {
            System.out.println("\n----- Order Details -----");
            System.out.println("Customer Name : " + customer);
            System.out.println("Food Ordered  : " + food);
        }
    }
}

// Base Class
class DeliveryStatus {

    void updateStatus() {
        System.out.println("Order is being prepared.");
    }
}