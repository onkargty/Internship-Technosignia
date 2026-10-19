public class Student {
    private int id;
    private String name;
    private double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getMarks() { return marks; }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) this.name = name;
    }

    public void setMarks(double marks) {
        if (marks >= 0 && marks <= 100) this.marks = marks;
    }

    public void display() {
        System.out.printf("ID: %d | Name: %s | Marks: %.2f%n", id, name, marks);
    }
}