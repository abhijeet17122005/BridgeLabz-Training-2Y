import java.util.Stack;

public class RevStkUsingRecursion {

    // Function to insert element at bottom
    public static void insertAtBottom(Stack<Integer> stack, int x) {
        // Base case
        if (stack.isEmpty()) {
            stack.push(x);
            return;
        }

        // Remove top element
        int top = stack.pop();

        // Recursive call
        insertAtBottom(stack, x);

        // Push back the removed element
        stack.push(top);
    }

    // Function to reverse stack
    public static void reverse(Stack<Integer> stack) {
        // Base case
        if (stack.isEmpty()) {
            return;
        }

        // Remove top element
        int top = stack.pop();

        // Reverse remaining stack
        reverse(stack);

        // Insert removed element at bottom
        insertAtBottom(stack, top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("Original Stack: " + stack);

        reverse(stack);

        System.out.println("Reversed Stack: " + stack);
    }
}