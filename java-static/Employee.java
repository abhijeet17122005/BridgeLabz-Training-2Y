public class Employee {
    private static String companyName = "Tech Solutions Pvt Ltd";
    private static int totalEmployees = 0;

    private final String id;
    private String name;
    private String designation;

    public Employee(String name, String id, String designation) {
        // this to initialize
        this.name = name;
        this.id = id; // final assigned here
        this.designation = designation;
        totalEmployees++;
    }

    public static void displayTotalEmployees() {
        System.out.println("Company: " + companyName + " | Total Employees: " + totalEmployees);
    }

    public void displayDetails(Object obj) {
        if (obj instanceof Employee) {
            System.out.println("Company: " + Employee.companyName);
            System.out.println("Name: " + this.name);
            System.out.println("ID: " + this.id);
            System.out.println("Designation: " + this.designation);
        } else {
            System.out.println("Object is not an Employee.");
        }
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Priya", "E100", "Developer");
        Employee e2 = new Employee("Arjun", "E101", "Tester");

        Employee.displayTotalEmployees();
        e1.displayDetails(e1);
        e2.displayDetails(new Object());
    }
}
