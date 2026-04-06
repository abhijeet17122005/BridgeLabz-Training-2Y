/**
 * Real-World Q6. Product Ratings Analyzer
 * Scenario: A website stores product ratings as a mix of primitive int values
 *           and Integer objects due to migration from an old system.
 * Task:
 *  - Combine both lists (int[] and ArrayList<Integer>) into a single list of Integer.
 *  - Find the average rating.
 *  - Handle null ratings gracefully by ignoring them.
 * Hint: Use Objects.nonNull() to filter out nulls and auto-boxing to merge lists.
 */

import java.util.ArrayList;
import java.util.Objects;

public class RW6_ProductRatingsAnalyzer {
    public static void main(String[] args) {
        // Old system: primitive int array
        int[] oldRatings = {4, 5, 3, 4};

        // New system: ArrayList with some nulls (missing ratings)
        ArrayList<Integer> newRatings = new ArrayList<>();
        newRatings.add(5);
        newRatings.add(null);   // missing rating
        newRatings.add(3);
        newRatings.add(null);   // missing rating
        newRatings.add(4);

        // Combine into one ArrayList<Integer>
        ArrayList<Integer> allRatings = new ArrayList<>();

        // Auto-boxing: int -> Integer
        for (int r : oldRatings) {
            allRatings.add(r);
        }
        allRatings.addAll(newRatings);

        System.out.println("All Ratings (including nulls): " + allRatings);

        // Filter nulls and calculate average
        int sum = 0, count = 0;
        for (Integer rating : allRatings) {
            if (Objects.nonNull(rating)) {
                sum += rating;   // auto-unboxing
                count++;
            }
        }

        double average = (count > 0) ? (double) sum / count : 0;
        System.out.println("Valid Ratings Count: " + count);
        System.out.printf("Average Rating     : %.2f%n", average);
    }
}

/*
 Expected Output:
 All Ratings (including nulls): [4, 5, 3, 4, 5, null, 3, null, 4]
 Valid Ratings Count: 7
 Average Rating     : 4.00
*/
