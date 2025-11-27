import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {
    // Reverse using recursion (only queue operations used explicitly)
    public static <T> void reverse(Queue<T> q) {
        if (q.isEmpty()) return;
        T x = q.remove();       // dequeue
        reverse(q);             // reverse remaining
        q.add(x);               // enqueue at end -> results in reversed order as recursion unwinds
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);

        System.out.println("Before: " + q); // [10, 20, 30]
        reverse(q);
        System.out.println("After:  " + q); // [30, 20, 10]
    }
}
