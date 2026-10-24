import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TemperatureServer {
    public static void main(String[] args) {
        try {
            TemperatureService service = new TemperatureServiceImpl();
            Registry registry = LocateRegistry.createRegistry(1100);
            registry.rebind("TemperatureService", service);
            System.out.println("Temperature RMI server is ready.");
        } catch (Exception e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}