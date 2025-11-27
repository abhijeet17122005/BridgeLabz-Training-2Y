import java.util.*;

public class NthFromEnd {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        int n = 2;
        String result = findNthFromEnd(list, n);
        System.out.println("Nth from end (" + n + "): " + result);
    }

    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        Iterator<T> first = list.iterator();
        Iterator<T> second = list.iterator();

        // Move first pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (first.hasNext())
                first.next();
            else
                return null; // n > list size
        }

        // Move both until first reaches end
        while (first.hasNext()) {
            first.next();
            second.next();
        }

        return second.next(); // Nth from end
    }
}
