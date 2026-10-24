import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class TemperatureClient {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Registry registry = LocateRegistry.getRegistry("localhost", 1100);
            TemperatureService service =
                    (TemperatureService) registry.lookup("TemperatureService");

            System.out.print("Enter temperature in Celsius: ");
            double c = sc.nextDouble();
            System.out.printf("Fahrenheit: %.2f%n",
                    service.celsiusToFahrenheit(c));

            System.out.print("Enter temperature in Fahrenheit: ");
            double f = sc.nextDouble();
            System.out.printf("Celsius: %.2f%n",
                    service.fahrenheitToCelsius(f));
        } catch (Exception e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}