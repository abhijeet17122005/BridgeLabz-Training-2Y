import java.util.*;

public class InvertMap {
    public static <K, V> Map<V, List<K>> invert(Map<K, V> input) {
        Map<V, List<K>> inverted = new HashMap<>();
        for (Map.Entry<K, V> e : input.entrySet()) {
            V value = e.getValue();
            K key = e.getKey();
            inverted.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }
        return inverted;
    }

    public static void main(String[] args) {
        Map<String, Integer> original = new HashMap<>();
        original.put("A", 1);
        original.put("B", 2);
        original.put("C", 1);

        Map<Integer, List<String>> result = invert(original);
        System.out.println(result); // {1=[A, C], 2=[B]}
    }
}
