import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a non-negative integer (0-20): ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid integer.");
            sc.close();
            return;
        }
        int n = sc.nextInt();
        if (n < 0 || n > 20) {
            System.out.println("Please enter a number from 0 to 20.");
        } else {
            long result = 1;
            for (int i = 2; i <= n; i++) result *= i;
            System.out.println(n + "! = " + result);
        }
        sc.close();
    }
}