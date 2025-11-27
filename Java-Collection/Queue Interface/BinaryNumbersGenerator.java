import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;

public class BinaryNumbersGenerator {
    public static List<String> generate(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) return result;

        Queue<String> q = new LinkedList<>();
        q.add("1");

        for (int i = 0; i < n; i++) {
            String s = q.remove();
            result.add(s);
            q.add(s + "0");
            q.add(s + "1");
        }
        return result;
    }

    public static void main(String[] args) {
        int N = 5;
        List<String> binaries = generate(N);
        System.out.println(binaries); // ["1", "10", "11", "100", "101"]
    }
}
