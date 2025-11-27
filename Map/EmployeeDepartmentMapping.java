import java.util.*;

public class EmployeeDepartmentMapping {
    public static void main(String[] args) {
        Map<Integer, String> empDept = new HashMap<>();
        // 1. Add multiple employees
        empDept.put(101, "HR");
        empDept.put(102, "Engineering");
        empDept.put(103, "Engineering");
        empDept.put(104, "Sales");
        empDept.put(105, "HR");
        empDept.put(106, "Support");

        // 2. Change department of an employee
        empDept.put(106, "Engineering"); // moved Support -> Engineering

        // 3. Find all employees in Engineering (reverse lookup)
        System.out.println("Employees in Engineering:");
        for (Map.Entry<Integer, String> e : empDept.entrySet()) {
            if ("Engineering".equals(e.getValue())) System.out.println(e.getKey());
        }

        // 4. Print total employees per department (grouping)
        Map<String, Integer> counts = new HashMap<>();
        for (String dept : empDept.values()) counts.put(dept, counts.getOrDefault(dept, 0) + 1);
        System.out.println("\nEmployees per department:");
        for (Map.Entry<String, Integer> e : counts.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }
}
