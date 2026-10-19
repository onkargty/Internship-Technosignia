import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0;
        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter marks for subject " + i + " (0-100): ");
            double marks;
            try { marks = Double.parseDouble(sc.nextLine().trim()); }
            catch (NumberFormatException ex) {
                System.out.println("Invalid input. Please run again and enter numeric marks.");
                sc.close(); return;
            }
            if (marks < 0 || marks > 100) {
                System.out.println("Marks must be between 0 and 100."); sc.close(); return;
            }
            total += marks;
        }
        double percentage = total / 5.0;
        String grade;
        if (percentage >= 90) grade = "A+";
        else if (percentage >= 80) grade = "A";
        else if (percentage >= 70) grade = "B";
        else if (percentage >= 60) grade = "C";
        else if (percentage >= 40) grade = "D";
        else grade = "F";
        System.out.printf("Total: %.2f/500%nPercentage: %.2f%%%nGrade: %s%n", total, percentage, grade);
        sc.close();
    }
}