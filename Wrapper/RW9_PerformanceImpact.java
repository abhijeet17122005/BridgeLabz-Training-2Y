/**
 * Real-World Q9. Performance Impact of Wrapper Classes
 * Scenario: Compare performance between ArrayList<Integer> and int[].
 * Task: Write a small benchmark that:
 *  1. Fills both with 1,000,000 numbers.
 *  2. Sums all elements.
 *  3. Measures the time taken for both.
 */

import java.util.ArrayList;

public class RW9_PerformanceImpact {

    static final int SIZE = 1_000_000;

    public static void main(String[] args) {
        // ---- Benchmark: int[] (primitive array) ----
        long startPrimitive = System.nanoTime();

        int[] primitiveArray = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            primitiveArray[i] = i + 1;
        }
        long primitiveSum = 0;
        for (int val : primitiveArray) {
            primitiveSum += val;
        }

        long endPrimitive = System.nanoTime();
        long primitiveTime = endPrimitive - startPrimitive;

        // ---- Benchmark: ArrayList<Integer> (wrapper objects) ----
        long startWrapper = System.nanoTime();

        ArrayList<Integer> wrapperList = new ArrayList<>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            wrapperList.add(i + 1);   // auto-boxing: int -> Integer
        }
        long wrapperSum = 0;
        for (Integer val : wrapperList) {
            wrapperSum += val;        // auto-unboxing: Integer -> int
        }

        long endWrapper = System.nanoTime();
        long wrapperTime = endWrapper - startWrapper;

        // ---- Results ----
        System.out.println("=== Performance Comparison (N = " + SIZE + ") ===");
        System.out.println();
        System.out.println("int[] (primitive array):");
        System.out.println("  Sum            : " + primitiveSum);
        System.out.println("  Time taken     : " + primitiveTime / 1_000_000 + " ms");
        System.out.println();
        System.out.println("ArrayList<Integer> (wrapper objects):");
        System.out.println("  Sum            : " + wrapperSum);
        System.out.println("  Time taken     : " + wrapperTime / 1_000_000 + " ms");
        System.out.println();
        System.out.println("--- Insight ---");
        System.out.println("int[] is faster because:");
        System.out.println("  1. No boxing/unboxing overhead.");
        System.out.println("  2. Primitives stored directly in contiguous memory.");
        System.out.println("  3. Integer objects carry extra memory overhead (~16 bytes each).");
        System.out.println("Use ArrayList<Integer> only when you need null support,");
        System.out.println("generics, or collection utilities.");
    }
}

/*
 Sample Output (actual times vary by machine):
 === Performance Comparison (N = 1000000) ===

 int[] (primitive array):
   Sum            : 500000500000
   Time taken     : 5 ms

 ArrayList<Integer> (wrapper objects):
   Sum            : 500000500000
   Time taken     : 38 ms
*/
