/**
 * Real-World Q5. Sensor Data Logger
 * Scenario: A temperature sensor provides data as primitives (double).
 *           But your IoT analytics system stores values as Double objects
 *           for advanced operations (like null checks or caching).
 * Task:
 *  - Create a method that accepts both primitive and wrapper inputs.
 *  - Show how auto-boxing and auto-unboxing help store and read data interchangeably.
 */

import java.util.ArrayList;

public class RW5_SensorDataLogger {

    // Accepts a primitive double; auto-boxing stores it as Double in the list
    public static void logReading(ArrayList<Double> log, double temperature) {
        Double boxed = temperature;   // auto-boxing
        log.add(boxed);
        System.out.println("Logged temperature: " + boxed + " °C");
    }

    // Reads from the list using auto-unboxing
    public static double getAverage(ArrayList<Double> log) {
        double sum = 0;
        for (Double temp : log) {
            sum += temp;   // auto-unboxing: Double -> double
        }
        return sum / log.size();
    }

    public static void main(String[] args) {
        ArrayList<Double> sensorLog = new ArrayList<>();

        // Logging primitive readings (auto-boxing happens inside logReading)
        logReading(sensorLog, 36.5);
        logReading(sensorLog, 37.2);
        logReading(sensorLog, 35.8);
        logReading(sensorLog, 38.1);

        // Read back as Double objects (wrapper)
        System.out.println("\nAll Readings (as Double objects): " + sensorLog);

        // Compute average using auto-unboxing
        double avg = getAverage(sensorLog);
        System.out.printf("Average Temperature: %.2f °C%n", avg);

        // Null check — only possible with wrapper objects, not primitives
        sensorLog.add(null);
        System.out.println("\nSensor log with a missing reading: " + sensorLog);
        for (Double reading : sensorLog) {
            if (reading == null) {
                System.out.println("  Missing sensor reading detected! Skipping.");
            } else {
                System.out.println("  Reading: " + reading + " °C");
            }
        }
    }
}

/*
 Sample Output:
 Logged temperature: 36.5 °C
 Logged temperature: 37.2 °C
 Logged temperature: 35.8 °C
 Logged temperature: 38.1 °C

 All Readings (as Double objects): [36.5, 37.2, 35.8, 38.1]
 Average Temperature: 36.90 °C

 Sensor log with a missing reading: [36.5, 37.2, 35.8, 38.1, null]
   Reading: 36.5 °C
   ...
   Missing sensor reading detected! Skipping.
*/
