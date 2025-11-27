import java.util.*;

public class GroupByDepartment {

    // Simple Employee class
    public static class Employee {
        private String name;
        private String department;

        public Employee(String name, String department) {
            this.name = name;
            this.department = department;
        }

        public String getName() { return name; }
        public String getDepartment() { return department; }

        @Override
        public String toString() {
            return name;
        }
    }

    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> grouped = new HashMap<>();
        for (Employee e : employees) {
            grouped.computeIfAbsent(e.getDepartment(), d -> new ArrayList<>()).add(e);
        }
        return grouped;
    }

    public static void main(String[] args) {
        List<Employee> list = Arrays.asList(
            new Employee("Alice", "HR"),
            new Employee("Bob", "IT"),
            new Employee("Carol", "HR")
        );

        Map<String, List<Employee>> grouped = groupByDepartment(list);

        // Nicely print
        for (Map.Entry<String, List<Employee>> entry : grouped.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        // Output:
        // HR: [Alice, Carol]
        // IT: [Bob]
    }
}
