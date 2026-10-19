import java.util.Scanner;

public class NumberPrograms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n;
        try { n = Integer.parseInt(sc.nextLine().trim()); }
        catch (NumberFormatException ex) {
            System.out.println("Invalid integer."); sc.close(); return;
        }
        System.out.println(n + (n % 2 == 0 ? " is even." : " is odd."));
        System.out.println(n + (isPrime(n) ? " is prime." : " is not prime."));
        if (n >= 0) System.out.println("Factorial: " + factorial(n));
        else System.out.println("Factorial is not defined for negative integers.");
        System.out.println(n + (isPalindrome(n) ? " is a palindrome." : " is not a palindrome."));
        sc.close();
    }
    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= n / i; i++) if (n % i == 0) return false;
        return true;
    }
    static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            if (result > Long.MAX_VALUE / i) {
                System.out.println("Factorial too large for long."); return -1;
            }
            result *= i;
        }
        return result;
    }
    static boolean isPalindrome(int n) {
        if (n < 0) return false;
        int original = n; long reversed = 0;
        while (n > 0) { reversed = reversed * 10 + n % 10; n /= 10; }
        return original == reversed;
    }
}