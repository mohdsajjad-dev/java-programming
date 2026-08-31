import java.util.Scanner;

public class OrderValidation {

    public static void validateOrder() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter item name: ");
            String itemName = scanner.nextLine();

            System.out.print("Enter quantity: ");
            int itemCount = scanner.nextInt();

            if (itemCount <= 0) {
                throw new IllegalArgumentException(
                    "Quantity must be greater than zero."
                );
            }

            System.out.println("Item: " + itemName);
            System.out.println("Quantity: " + itemCount);
            System.out.println("Item added to cart successfully.");

        } catch (IllegalArgumentException exception) {
            System.out.println("Order Error: "
                    + exception.getMessage());

        } catch (Exception exception) {
            System.out.println("Invalid quantity. Please enter a number.");
        }

        scanner.close();
    }

    public static void main(String[] args) {
        validateOrder();
    }
}