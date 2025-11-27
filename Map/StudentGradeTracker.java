import java.util.*;

public class StudentGradeTracker {
    public static void main(String[] args) {
        // Use TreeMap to keep names sorted alphabetically
        Map<String, Double> grades = new TreeMap<>();

        // 1. Add several students
        grades.put("Asha", 78.5);
        grades.put("Devang", 92.0);
        grades.put("Priya", 85.0);
        grades.put("Ravi", 60.0);

        // 2. Update grade (student retakes test)
        grades.put("Ravi", 72.0); // update Ravi's grade

        // 3. Remove a student who dropped out
        grades.remove("Asha");

        // 4. Print students and grades in alphabetical order
        System.out.println("Student Grades (alphabetical):");
        for (Map.Entry<String, Double> e : grades.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }
}
