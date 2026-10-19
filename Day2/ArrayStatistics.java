import java.util.Scanner;

public class ArrayStatistics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many numbers (1-100)? ");
        int size;
        try { size = Integer.parseInt(sc.nextLine().trim()); }
        catch (NumberFormatException ex) { System.out.println("Invalid size."); sc.close(); return; }
        if (size < 1 || size > 100) {
            System.out.println("Size must be between 1 and 100."); sc.close(); return;
        }
        int[] numbers = new int[size];
        long sum = 0; int min = Integer.MAX_VALUE; int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            try { numbers[i] = Integer.parseInt(sc.nextLine().trim()); }
            catch (NumberFormatException ex) { System.out.println("Invalid integer."); sc.close(); return; }
            sum += numbers[i]; min = Math.min(min, numbers[i]); max = Math.max(max, numbers[i]);
        }
        System.out.println("Numbers:");
        for (int number : numbers) System.out.print(number + " ");
        System.out.println("\nSum: " + sum);
        System.out.println("Average: " + (sum / (double) size));
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
        sc.close();
    }
}