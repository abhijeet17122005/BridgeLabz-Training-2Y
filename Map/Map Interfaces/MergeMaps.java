import java.util.*;

public class MergeMaps {
    public static Map<String, Integer> merge(Map<String, Integer> a, Map<String, Integer> b) {
        Map<String, Integer> result = new HashMap<>(a); // start with a's entries
        for (Map.Entry<String, Integer> e : b.entrySet()) {
            result.put(e.getKey(), result.getOrDefault(e.getKey(), 0) + e.getValue());
        }
        return result;
    }

    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        Map<String, Integer> merged = merge(map1, map2);
        System.out.println(merged); // {A=1, B=5, C=4}
    }
}
