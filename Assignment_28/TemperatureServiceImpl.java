import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TemperatureServiceImpl extends UnicastRemoteObject
        implements TemperatureService {
    public TemperatureServiceImpl() throws RemoteException {
        super();
    }

    public double celsiusToFahrenheit(double celsius) throws RemoteException {
        return (celsius * 9.0 / 5.0) + 32;
    }

    public double fahrenheitToCelsius(double fahrenheit) throws RemoteException {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }
}