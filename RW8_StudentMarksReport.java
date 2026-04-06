/**
 * Real-World Q8. Student Marks Report
 * Scenario: You receive student marks in various formats:
 *           "85", 95, Integer.valueOf(88), and sometimes "null".
 * Task:
 *  - Convert all inputs into valid Integer objects.
 *  - Ignore invalid or null entries.
 *  - Calculate the average of valid marks.
 */

import java.util.ArrayList;

public class RW8_StudentMarksReport {

    // Safely parse any object to Integer; returns null if invalid
    public static Integer parseToInteger(Object input) {
        if (input == null) return null;

        String str = input.toString().trim();
        if (str.equalsIgnoreCase("null") || str.isEmpty()) return null;

        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        // Mixed format inputs as they might come from different sources
        Object[] rawMarks = {"85", 95, Integer.valueOf(88), "null", "72", "abc", null, "90"};

        ArrayList<Integer> validMarks = new ArrayList<>();

        System.out.println("Processing marks:");
        for (Object raw : rawMarks) {
            Integer mark = parseToInteger(raw);
            if (mark != null) {
                validMarks.add(mark);
                System.out.println("  Valid mark   : " + mark);
            } else {
                System.out.println("  Invalid/null : " + raw + " -> skipped");
            }
        }

        // Calculate average using auto-unboxing
        int sum = 0;
        for (Integer mark : validMarks) {
            sum += mark;   // auto-unboxing
        }
        double average = validMarks.isEmpty() ? 0 : (double) sum / validMarks.size();

        System.out.println("\nValid Marks  : " + validMarks);
        System.out.println("Total Marks  : " + sum);
        System.out.printf("Average Marks: %.2f%n", average);
    }
}

/*
 Expected Output:
 Processing marks:
   Valid mark   : 85
   Valid mark   : 95
   Valid mark   : 88
   Invalid/null : null -> skipped
   Valid mark   : 72
   Invalid/null : abc -> skipped
   Invalid/null : null -> skipped
   Valid mark   : 90

 Valid Marks  : [85, 95, 88, 72, 90]
 Total Marks  : 430
 Average Marks: 86.00
*/
