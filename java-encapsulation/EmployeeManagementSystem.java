interface Department {
    void assignDepartment(String dept);
    String getDepartmentDetails();
}

abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) { this.baseSalary = baseSalary; }

    public void displayDetails() {
        System.out.println("ID: " + employeeId + ", Name: " + name + ", Base Salary: " + baseSalary);
    }

    public abstract double calculateSalary();
}

class FullTimeEmployee extends Employee implements Department {
    private String department;

    public FullTimeEmployee(int id, String name, double salary) {
        super(id, name, salary);
    }

    public double calculateSalary() { return getBaseSalary(); }

    public void assignDepartment(String dept) { this.department = dept; }
    public String getDepartmentDetails() { return department; }
}

class PartTimeEmployee extends Employee implements Department {
    private int hoursWorked;
    private String department;

    public PartTimeEmployee(int id, String name, double rate, int hours) {
        super(id, name, rate);
        this.hoursWorked = hours;
    }

    public double calculateSalary() { return getBaseSalary() * hoursWorked; }

    public void assignDepartment(String dept) { this.department = dept; }
    public String getDepartmentDetails() { return department; }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee e1 = new FullTimeEmployee(101, "Alice", 50000);
        Employee e2 = new PartTimeEmployee(102, "Bob", 200, 40);

        e1.displayDetails();
        System.out.println("Salary: " + e1.calculateSalary());

        e2.displayDetails();
        System.out.println("Salary: " + e2.calculateSalary());
    }
}
