import java.util.*;

public class SymmetricDifference {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        Set<Integer> result = new HashSet<>(set1);
        result.addAll(set2); // Union
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2); // Intersection
        result.removeAll(intersection); // Remove common elements

        System.out.println("Symmetric Difference: " + result);
    }
}
