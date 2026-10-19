import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(101, "Rahul", 85));
        students.add(new Student(102, "Priya", 92));

        while (true) {
            System.out.println("\n--- Student Management ---");
            System.out.println("1. Display students");
            System.out.println("2. Add student");
            System.out.println("3. Exit");
            System.out.print("Choose: ");

            try {
                int choice = Integer.parseInt(input.nextLine().trim());
                if (choice == 1) {
                    if (students.isEmpty()) System.out.println("No students found.");
                    for (Student s : students) s.display();
                } else if (choice == 2) {
                    System.out.print("Student ID: ");
                    int id = Integer.parseInt(input.nextLine().trim());
                    System.out.print("Student name: ");
                    String name = input.nextLine().trim();
                    System.out.print("Marks (0-100): ");
                    double marks = Double.parseDouble(input.nextLine().trim());
                    if (name.isEmpty() || marks < 0 || marks > 100) {
                        System.out.println("Invalid name or marks.");
                    } else {
                        students.add(new Student(id, name, marks));
                        System.out.println("Student added.");
                    }
                } else if (choice == 3) {
                    System.out.println("Goodbye!");
                    break;
                } else {
                    System.out.println("Choose 1, 2, or 3.");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input. Enter a valid number.");
            }
        }
        input.close();
    }
}