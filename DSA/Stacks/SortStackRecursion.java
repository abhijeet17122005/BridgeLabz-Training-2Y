import java.util.Stack;

public class SortStackRecursion {

   
    public static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) return;

        int top = stack.pop();

        
        sortStack(stack);

        
        insertSorted(stack, top);
    }

    
    public static void insertSorted(Stack<Integer> stack, int value) {
        
        if (stack.isEmpty() || stack.peek() <= value) {
            stack.push(value);
            return;
        }

        int top = stack.pop();

        // Recursive call
        insertSorted(stack, value);

        // Push back removed element
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(10);
        stack.push(50);
        stack.push(20);

        sortStack(stack);

        
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}