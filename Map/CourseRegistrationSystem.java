import java.util.*;

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        Map<String, Integer> courses = new HashMap<>();

        // 1. Add courses with initial counts
        courses.put("CS101", 48);
        courses.put("CS102", 52);
        courses.put("MA101", 3);
        courses.put("PH101", 10);
        courses.put("EE101", 49);

        // 2. Add/drop students (never negative)
        register(courses, "CS101", 3); // now 51
        drop(courses, "MA101", 2);     // now 1
        drop(courses, "PH101", 15);    // attempt to drop more -> will clamp to 0

        // 3. Print near full (>=50) and under-subscribed (<5)
        System.out.println("Near full courses (>=50):");
        for (Map.Entry<String, Integer> e : courses.entrySet()) {
            if (e.getValue() >= 50) System.out.println(e.getKey() + " -> " + e.getValue());
        }

        System.out.println("\nUnder-subscribed courses (<5):");
        for (Map.Entry<String, Integer> e : courses.entrySet()) {
            if (e.getValue() < 5) System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }

    static void register(Map<String, Integer> courses, String code, int n) {
        courses.put(code, courses.getOrDefault(code, 0) + n);
    }

    static void drop(Map<String, Integer> courses, String code, int n) {
        int cur = courses.getOrDefault(code, 0);
        int updated = Math.max(0, cur - n);
        courses.put(code, updated);
    }
}
