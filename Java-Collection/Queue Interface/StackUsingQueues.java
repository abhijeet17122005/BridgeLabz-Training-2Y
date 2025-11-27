import java.util.LinkedList;
import java.util.Queue;
import java.util.NoSuchElementException;

public class StackUsingQueues {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    // push: put into q2, move all from q1 to q2, swap
    public void push(int x) {
        q2.add(x);
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        // swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        if (q1.isEmpty()) throw new NoSuchElementException("Stack is empty");
        return q1.remove();
    }

    public int top() {
        if (q1.isEmpty()) throw new NoSuchElementException("Stack is empty");
        return q1.peek();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues s = new StackUsingQueues();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("Top before pop: " + s.top()); // 3
        System.out.println("Pop: " + s.pop());            // 3
        System.out.println("Top after pop: " + s.top());  // 2
    }
}
