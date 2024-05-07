import java.rmi.Naming;
import java.util.Scanner;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            // Lookup the remote object from the RMI registry
            Calculator calculator = (Calculator) Naming.lookup("CalculatorService");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Enter operation (add/subtract/multiply/divide): ");
                String operation = scanner.nextLine();
                if (operation.equals("exit")) {
                    break;
                }

                System.out.print("Enter first number: ");
                int a = scanner.nextInt();
                System.out.print("Enter second number: ");
                int b = scanner.nextInt();

                int result = 0;
                switch (operation) {
                    case "add":
                        result = calculator.add(a, b);
                        break;
                    case "subtract":
                        result = calculator.subtract(a, b);
                        break;
                    case "multiply":
                        result = calculator.multiply(a, b);
                        break;
                    case "divide":
                        result = calculator.divide(a, b);
                        break;
                    default:
                        System.out.println("Invalid operation. Please try again.");
                        continue;
                }

                System.out.println("Result: " + result);
                scanner.nextLine(); // Consume newline
            }

            scanner.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
