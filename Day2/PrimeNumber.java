import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid integer.");
            sc.close();
            return;
        }
        int n = sc.nextInt();
        boolean prime = n >= 2;
        for (int i = 2; prime && i <= n / i; i++) {
            if (n % i == 0) prime = false;
        }
        System.out.println(n + (prime ? " is prime." : " is not prime."));
        sc.close();
    }
}