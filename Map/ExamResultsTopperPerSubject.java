import java.util.*;

public class ExamResultsTopperPerSubject {
    public static void main(String[] args) {
        // Map<Subject, Map<Student, Marks>>
        Map<String, Map<String, Integer>> results = new HashMap<>();

        // 1. Add subjects and marks
        results.put("Math", new HashMap<>());
        results.get("Math").put("Aman", 88);
        results.get("Math").put("Bina", 95);
        results.get("Math").put("Charu", 78);

        results.put("Physics", new HashMap<>());
        results.get("Physics").put("Aman", 70);
        results.get("Physics").put("Bina", 82);
        results.get("Physics").put("Charu", 91);

        results.put("Chemistry", new HashMap<>());
        results.get("Chemistry").put("Aman", 92);
        results.get("Chemistry").put("Bina", 89);
        results.get("Chemistry").put("Charu", 85);

        // 2. Find top scorer per subject
        System.out.println("Topper per subject:");
        for (String subject : results.keySet()) {
            Map<String, Integer> map = results.get(subject);
            String topStudent = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
            int topMarks = map.get(topStudent);
            System.out.println(subject + " -> " + topStudent + " (" + topMarks + ")");
        }

        // 3. Print average score per subject
        System.out.println("\nAverage per subject:");
        for (String subject : results.keySet()) {
            Map<String, Integer> map = results.get(subject);
            double avg = map.values().stream().mapToInt(Integer::intValue).average().orElse(0.0);
            System.out.println(subject + " -> " + avg);
        }

        // 4. List subjects where at least one student scored above 90
        System.out.println("\nSubjects with a score > 90:");
        for (String subject : results.keySet()) {
            boolean any = results.get(subject).values().stream().anyMatch(m -> m > 90);
            if (any) System.out.println(subject);
        }
    }
}
