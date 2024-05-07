import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            // Create the remote object
            CalculatorImpl calculator = new CalculatorImpl();

            // Create and start the RMI registry
            LocateRegistry.createRegistry(1098);

            // Bind the remote object to the registry
            Naming.rebind("CalculatorService", calculator);

            System.out.println("Calculator service is ready.");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
