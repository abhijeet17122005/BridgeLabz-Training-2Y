/**
 * Q7. Wrapper Objects in Collections
 * You're given an array of primitive double values:
 *   double[] prices = {10.5, 20.0, 35.75, 5.5};
 * Convert them into an ArrayList<Double> using wrapper objects.
 * Then calculate and print:
 *  - The highest price
 *  - The average price
 */

import java.util.ArrayList;
import java.util.Collections;

public class Q7_WrapperObjectsInCollections {
    public static void main(String[] args) {
        double[] prices = {10.5, 20.0, 35.75, 5.5};

        // Convert primitive array to ArrayList<Double> using auto-boxing
        ArrayList<Double> priceList = new ArrayList<>();
        for (double price : prices) {
            priceList.add(price);   // auto-boxing: double -> Double
        }

        // Highest price using Collections.max()
        double highest = Collections.max(priceList);

        // Average price
        double sum = 0;
        for (double p : priceList) {   // auto-unboxing: Double -> double
            sum += p;
        }
        double average = sum / priceList.size();

        System.out.println("Price List   : " + priceList);
        System.out.println("Highest Price: " + highest);
        System.out.printf("Average Price: %.2f%n", average);
    }
}

/*
 Expected Output:
 Price List   : [10.5, 20.0, 35.75, 5.5]
 Highest Price: 35.75
 Average Price: 17.94
*/
