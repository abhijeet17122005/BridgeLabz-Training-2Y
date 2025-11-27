import java.util.*;

public class StudentAttendanceTracker {
    public static void main(String[] args) {
        // 5 students
        List<String> students = Arrays.asList("Anil", "Bina", "Charu", "Deep", "Esha");
        Map<String, Integer> attendance = new HashMap<>();
        for (String s : students) attendance.put(s, 0);

        // Simulate 15 days; each day a subset is present
        List<List<String>> days = new ArrayList<>();
        Random r = new Random(1);
        for (int d = 0; d < 15; d++) {
            List<String> present = new ArrayList<>();
            for (String s : students) {
                if (r.nextBoolean()) present.add(s);
            }
            days.add(present);
        }

        // Mark attendance
        for (List<String> present : days) {
            for (String s : present) {
                attendance.put(s, attendance.get(s) + 1);
            }
        }

        System.out.println("Attendance counts after 15 days:");
        for (Map.Entry<String, Integer> e : attendance.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }

        // List students present fewer than 10 days
        System.out.println("\nStudents with fewer than 10 days present:");
        for (Map.Entry<String, Integer> e : attendance.entrySet()) {
            if (e.getValue() < 10) System.out.println(e.getKey() + " (" + e.getValue() + ")");
        }
    }
}
