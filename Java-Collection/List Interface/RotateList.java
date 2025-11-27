import java.util.*;

public class RotateList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        int k = 2; // Rotate by 2
        rotateList(list, k);
        System.out.println("Rotated List: " + list);
    }

    public static <T> void rotateList(List<T> list, int k) {
        int n = list.size();
        k = k % n; // handle large rotations
        List<T> rotated = new ArrayList<>();

        for (int i = k; i < n; i++) rotated.add(list.get(i));
        for (int i = 0; i < k; i++) rotated.add(list.get(i));

        list.clear();
        list.addAll(rotated);
    }
}
