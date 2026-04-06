/**
 * Real-World Q2. Employee Data Processing
 * Scenario: A file contains employee ages as primitive int values,
 *           but the HR analytics module expects an ArrayList of Integer objects.
 * Task:
 *  - Convert int[] array into ArrayList<Integer> using wrapper classes.
 *  - Find the youngest and oldest employee ages using Collections.min() and Collections.max().
 */

import java.util.ArrayList;
import java.util.Collections;

public class RW2_EmployeeDataProcessing {
    public static void main(String[] args) {
        int[] ages = {34, 28, 45, 23, 52, 39, 31};

        // Convert primitive int[] to ArrayList<Integer> via auto-boxing
        ArrayList<Integer> ageList = new ArrayList<>();
        for (int age : ages) {
            ageList.add(age);   // auto-boxing: int -> Integer
        }

        int youngest = Collections.min(ageList);
        int oldest   = Collections.max(ageList);

        System.out.println("Employee Ages  : " + ageList);
        System.out.println("Youngest Age   : " + youngest);
        System.out.println("Oldest Age     : " + oldest);
    }
}

/*
 Expected Output:
 Employee Ages  : [34, 28, 45, 23, 52, 39, 31]
 Youngest Age   : 23
 Oldest Age     : 52
*/
