import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class StudentRecordsApp {
    private static final String FILE_NAME = "students.txt";
    private static final ArrayList<StudentRecord> students = new ArrayList<>();
    private static final HashMap<Integer, StudentRecord> byId = new HashMap<>();

    static class StudentRecord {
        int id;
        String name;
        double marks;

        StudentRecord(int id, String name, double marks) {
            this.id = id;
            this.name = name;
            this.marks = marks;
        }

        public String toString() {
            return String.format("ID: %d | Name: %s | Marks: %.2f", id, name, marks);
        }

        String toFileLine() {
            return id + "," + name.replace(",", " ") + "," + marks;
        }
    }

    private static void addStudent(int id, String name, double marks) {
        if (byId.containsKey(id)) {
            System.out.println("That ID already exists.");
            return;
        }
        StudentRecord student = new StudentRecord(id, name, marks);
        students.add(student);
        byId.put(id, student);
        System.out.println("Student added.");
    }

    private static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records.");
            return;
        }
        students.forEach(System.out::println); // Java Stream
    }

    private static void searchById(int id) {
        StudentRecord s = byId.get(id); // HashMap lookup
        System.out.println(s == null ? "Student not found." : s);
    }

    private static void searchByName(String name) {
        List<StudentRecord> found = students.stream()
                .filter(s -> s.name.equalsIgnoreCase(name))
                .collect(Collectors.toList());
        if (found.isEmpty()) System.out.println("Student not found.");
        else found.forEach(System.out::println);
    }

    private static void sortByName() {
        students.stream().sorted(Comparator.comparing(s -> s.name.toLowerCase()))
                .forEach(System.out::println);
    }

    private static void sortByMarks() {
        students.stream().sorted(Comparator.comparingDouble((StudentRecord s) -> s.marks).reversed())
                .forEach(System.out::println);
    }

    private static void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (StudentRecord s : students) writer.println(s.toFileLine());
            System.out.println("Saved to " + FILE_NAME);
        } catch (IOException ex) {
            System.out.println("Could not save file: " + ex.getMessage());
        }
    }

    private static void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No saved file found yet.");
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int loaded = 0;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 3);
                if (parts.length != 3) continue;
                int id = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                double marks = Double.parseDouble(parts[2].trim());
                if (!byId.containsKey(id)) {
                    students.add(new StudentRecord(id, name, marks));
                    byId.put(id, students.get(students.size() - 1));
                    loaded++;
                }
            }
            System.out.println("Loaded " + loaded + " record(s).");
        } catch (IOException | NumberFormatException ex) {
            System.out.println("Could not load data: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        addStudent(101, "Rahul", 85);
        addStudent(102, "Priya", 92);
        addStudent(103, "Amit", 78);

        while (true) {
            System.out.println("\n--- Advanced Student Records ---");
            System.out.println("1 Add student  2 Display all  3 Search ID");
            System.out.println("4 Search name  5 Sort by name  6 Sort by marks");
            System.out.println("7 Save file    8 Load file    9 Exit");
            System.out.print("Choice: ");
            try {
                int choice = Integer.parseInt(sc.nextLine().trim());
                switch (choice) {
                    case 1:
                        System.out.print("ID: ");
                        int id = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("Name: ");
                        String name = sc.nextLine().trim();
                        System.out.print("Marks (0-100): ");
                        double marks = Double.parseDouble(sc.nextLine().trim());
                        if (name.isEmpty() || marks < 0 || marks > 100) {
                            System.out.println("Invalid name or marks.");
                        } else addStudent(id, name, marks);
                        break;
                    case 2: displayStudents(); break;
                    case 3:
                        System.out.print("ID to search: ");
                        searchById(Integer.parseInt(sc.nextLine().trim()));
                        break;
                    case 4:
                        System.out.print("Name to search: ");
                        searchByName(sc.nextLine().trim());
                        break;
                    case 5: sortByName(); break;
                    case 6: sortByMarks(); break;
                    case 7: saveToFile(); break;
                    case 8: loadFromFile(); break;
                    case 9: saveToFile(); System.out.println("Goodbye!"); sc.close(); return;
                    default: System.out.println("Choose a number from 1 to 9.");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number. Please try again.");
            }
        }
    }
}