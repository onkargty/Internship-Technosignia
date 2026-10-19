import java.util.Scanner;

public class EvenOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid integer.");
            sc.close();
            return;
        }
        int number = sc.nextInt();
        System.out.println(number + (number % 2 == 0 ? " is even." : " is odd."));
        sc.close();
    }
}