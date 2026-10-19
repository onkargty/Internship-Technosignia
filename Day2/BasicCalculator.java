import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Basic Calculator ---");
        System.out.print("Enter first number: ");
        double a = readNumber(sc);
        System.out.print("Enter operator (+, -, *, /): ");
        String operator = sc.nextLine().trim();
        System.out.print("Enter second number: ");
        double b = readNumber(sc);
        switch (operator) {
            case "+": System.out.println("Result: " + (a + b)); break;
            case "-": System.out.println("Result: " + (a - b)); break;
            case "*": System.out.println("Result: " + (a * b)); break;
            case "/":
                if (b == 0) System.out.println("Error: cannot divide by zero.");
                else System.out.println("Result: " + (a / b));
                break;
            default: System.out.println("Invalid operator.");
        }
        sc.close();
    }
    private static double readNumber(Scanner sc) {
        while (true) {
            try { return Double.parseDouble(sc.nextLine().trim()); }
            catch (NumberFormatException ex) { System.out.print("Please enter a valid number: "); }
        }
    }
}