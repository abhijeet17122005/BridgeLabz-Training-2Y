import java.util.*;

public class DistinctWindow {

    public static void countDistinct(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        System.out.print(map.size() + " ");

        for (int i = k; i < arr.length; i++) {

            int outgoing = arr[i - k];
            map.put(outgoing, map.get(outgoing) - 1);

            if (map.get(outgoing) == 0) {
                map.remove(outgoing);
            }

            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

            System.out.print(map.size() + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,3,4,2,3};
        int k = 4;
        countDistinct(arr, k);
    }
}
