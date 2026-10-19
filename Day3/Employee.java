public class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }

    public void setSalary(double salary) {
        if (salary >= 0) this.salary = salary;
    }

    public void display() {
        System.out.printf("Employee ID: %d | Name: %s | Salary: %.2f%n",
                id, name, salary);
    }
}