import java.util.Scanner;

public class NumberPrograms {
    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Day 2 Number Practice ===");
            System.out.println("1. Check even or odd");
            System.out.println("2. Find the largest of three numbers");
            System.out.println("3. Calculate factorial");
            System.out.println("4. Check whether a number is prime");
            System.out.println("5. Reverse a number");
            System.out.println("6. Print a multiplication table");
            System.out.println("7. Check palindrome (extra practice)");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = readInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter a number: ");
                    int evenOdd = readInt();
                    System.out.println(evenOdd + (evenOdd % 2 == 0 ? " is even." : " is odd."));
                    break;
                case 2:
                    System.out.print("Enter three numbers separated by spaces: ");
                    int a = readInt();
                    int b = readInt();
                    int c = readInt();
                    System.out.println("Largest number: " + Math.max(a, Math.max(b, c)));
                    break;
                case 3:
                    System.out.print("Enter a non-negative integer (0-20): ");
                    int factN = readInt();
                    if (factN < 0 || factN > 20) {
                        System.out.println("Please enter a number from 0 to 20.");
                    } else {
                        System.out.println("Factorial: " + factorial(factN));
                    }
                    break;
                case 4:
                    System.out.print("Enter a number: ");
                    int primeN = readInt();
                    System.out.println(primeN + (isPrime(primeN) ? " is prime." : " is not prime."));
                    break;
                case 5:
                    System.out.print("Enter a number: ");
                    int reverseN = readInt();
                    System.out.println("Reversed number: " + reverseNumber(reverseN));
                    break;
                case 6:
                    System.out.print("Enter a number for its multiplication table: ");
                    int tableN = readInt();
                    for (int i = 1; i <= 10; i++) {
                        System.out.println(tableN + " x " + i + " = " + ((long) tableN * i));
                    }
                    break;
                case 7:
                    System.out.print("Enter a number: ");
                    int palindromeN = readInt();
                    System.out.println(palindromeN + (isPalindrome(palindromeN)
                            ? " is a palindrome." : " is not a palindrome."));
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    SC.close();
                    return;
                default:
                    System.out.println("Invalid option. Choose 0-7.");
            }
        }
    }

    private static int readInt() {
        while (true) {
            String input = SC.nextLine().trim();
            try {
                // Also supports entering multiple numbers on one line for option 2.
                if (input.contains(" ")) {
                    String[] parts = input.split("\\s+");
                    for (int i = 1; i < parts.length; i++) {
                        // Keep extra values available for the next reads.
                        pendingValues.add(parts[i]);
                    }
                    input = parts[0];
                }
                if (!pendingValues.isEmpty()) {
                    String value = input;
                    input = pendingValues.remove(0);
                    pendingValues.add(0, value);
                }
                return Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                System.out.print("Invalid integer. Try again: ");
            }
        }
    }

    private static final java.util.List<String> pendingValues = new java.util.ArrayList<>();

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) result *= i;
        return result;
    }

    private static long reverseNumber(int n) {
        long value = Math.abs((long) n);
        long reversed = 0;
        while (value > 0) {
            reversed = reversed * 10 + value % 10;
            value /= 10;
        }
        return n < 0 ? -reversed : reversed;
    }

    private static boolean isPalindrome(int n) {
        return n >= 0 && n == reverseNumber(n);
    }
}