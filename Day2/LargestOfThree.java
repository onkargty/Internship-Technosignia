import java.util.Scanner;

public class LargestOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter three integers: ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid input.");
            sc.close();
            return;
        }
        int a = sc.nextInt();
        if (!sc.hasNextInt()) {
            System.out.println("Invalid input.");
            sc.close();
            return;
        }
        int b = sc.nextInt();
        if (!sc.hasNextInt()) {
            System.out.println("Invalid input.");
            sc.close();
            return;
        }
        int c = sc.nextInt();
        System.out.println("Largest number: " + Math.max(a, Math.max(b, c)));
        sc.close();
    }
}