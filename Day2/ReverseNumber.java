import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid integer.");
            sc.close();
            return;
        }
        int n = sc.nextInt();
        long value = Math.abs((long) n);
        long reversed = 0;
        while (value > 0) {
            reversed = reversed * 10 + value % 10;
            value /= 10;
        }
        if (n < 0) reversed = -reversed;
        System.out.println("Reversed number: " + reversed);
        sc.close();
    }
}