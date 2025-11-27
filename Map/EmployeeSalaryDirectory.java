import java.util.*;

public class EmployeeSalaryDirectory {
    public static void main(String[] args) {
        Map<String, Double> salaries = new HashMap<>();
        salaries.put("Rohan", 45000.0);
        salaries.put("Simran", 52000.0);
        salaries.put("Kiran", 60000.0);
        salaries.put("Mira", 60000.0);
        salaries.put("Arjun", 30000.0);
        salaries.put("Tara", 48000.0);

        // Give some raises
        giveRaise(salaries, "Arjun", 10); // +10%
        giveRaise(salaries, "Kiran", 5);  // +5%
        giveRaise(salaries, "Unknown", 5); // employee not found

        // Average salary
        double total = 0;
        for (double s : salaries.values()) total += s;
        double avg = total / salaries.size();
        System.out.println("Average salary: " + avg);

        // Highest-paid employee(s)
        double max = Collections.max(salaries.values());
        System.out.println("Highest salary: " + max);
        System.out.println("Employees with highest salary:");
        for (Map.Entry<String, Double> e : salaries.entrySet()) {
            if (e.getValue() == max) System.out.println(e.getKey());
        }
    }

    static void giveRaise(Map<String, Double> map, String name, double percent) {
        if (!map.containsKey(name)) {
            System.out.println("Employee not found: " + name);
            return;
        }
        double cur = map.get(name);
        double updated = cur * (1 + percent / 100.0);
        map.put(name, updated);
        System.out.println("Updated salary for " + name + ": " + updated);
    }
}
