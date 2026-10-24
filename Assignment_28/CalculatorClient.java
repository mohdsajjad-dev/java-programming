import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Calculator service = (Calculator) registry.lookup("CalculatorService");

            System.out.println("Addition: " + service.add(20, 10));
            System.out.println("Subtraction: " + service.subtract(20, 10));
        } catch (Exception e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}