/**
 * Q4. Wrapper Comparison
 * Given:
 *   Integer a = 100;  Integer b = 100;
 *   Integer c = 200;  Integer d = 200;
 *
 * Print and explain the results of: a == b, c == d, a.equals(b)
 *
 * Explanation:
 *   Java caches Integer objects for values in the range [-128, 127].
 *   So a and b refer to the SAME cached object  → a == b  is TRUE.
 *   200 is outside that cache range, so c and d are DIFFERENT objects → c == d is FALSE.
 *   equals() always compares the numeric VALUE, so a.equals(b) is TRUE regardless of caching.
 */

public class Q4_WrapperComparison {
    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 100;
        Integer c = 200;
        Integer d = 200;

        System.out.println("a == b       : " + (a == b));        // true  (cached objects)
        System.out.println("c == d       : " + (c == d));        // false (outside cache)
        System.out.println("a.equals(b)  : " + a.equals(b));     // true  (value comparison)

        System.out.println("\n--- Explanation ---");
        System.out.println("Java caches Integer objects for values -128 to 127.");
        System.out.println("a and b both point to the SAME cached object (100 is in range), so a == b is true.");
        System.out.println("c and d are DIFFERENT objects (200 is outside range), so c == d is false.");
        System.out.println("equals() compares values, so a.equals(b) is always true when values match.");
    }
}
