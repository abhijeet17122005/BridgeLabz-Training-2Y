/**
 * Q3. Auto-boxing and Auto-unboxing
 * Create an ArrayList<Integer> and add 5 integer values using auto-boxing.
 * Then calculate their sum using auto-unboxing.
 *
 * Expected Output: Sum of numbers = 55
 */

import java.util.ArrayList;

public class Q3_AutoboxingUnboxing {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        // Auto-boxing: primitives are automatically converted to Integer objects
        numbers.add(10);
        numbers.add(20);
        numbers.add(5);
        numbers.add(15);
        numbers.add(5);

        int sum = 0;
        // Auto-unboxing: Integer objects are automatically converted back to int
        for (int num : numbers) {
            sum += num;
        }

        System.out.println("Sum of numbers = " + sum);
    }
}
