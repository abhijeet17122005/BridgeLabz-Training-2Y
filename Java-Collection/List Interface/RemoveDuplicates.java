import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 2, 2, 3, 4));
        List<Integer> result = removeDuplicates(list);
        System.out.println("Without Duplicates: " + result);
    }

    public static <T> List<T> removeDuplicates(List<T> list) {
        List<T> result = new ArrayList<>();
        Set<T> seen = new HashSet<>();

        for (T item : list) {
            if (!seen.contains(item)) {
                seen.add(item);
                result.add(item);
            }
        }
        return result;
    }
}
