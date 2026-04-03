import java.util.Scanner;

class DynamicArrayStack {

    private int[] stack;
    private int top;
    private int capacity;

    // Constructor
    public DynamicArrayStack(int size) {
        stack = new int[size];
        capacity = size;
        top = -1;
    }

    // Resize the array when full
    private void resize() {
        capacity = capacity * 2;
        int[] newStack = new int[capacity];

        for(int i = 0; i <= top; i++){
            newStack[i] = stack[i];
        }

        stack = newStack;
        System.out.println("Stack resized to capacity: " + capacity);
    }

    // Push operation
    public void push(int value) {
        if(top == capacity - 1){
            resize();
        }

        stack[++top] = value;
    }

    // Pop operation
    public int pop() {
        if(top == -1){
            System.out.println("Stack Underflow");
            return -1;
        }

        return stack[top--];
    }

    // Peek operation
    public int peek() {
        if(top == -1){
            System.out.println("Stack is Empty");
            return -1;
        }

        return stack[top];
    }

    // Display stack
    public void display() {
        if(top == -1){
            System.out.println("Stack is Empty");
            return;
        }

        for(int i = top; i >= 0; i--){
            System.out.println(stack[i]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DynamicArrayStack stack = new DynamicArrayStack(3);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40); // triggers resize

        System.out.println("Stack elements:");
        stack.display();

        System.out.println("Popped: " + stack.pop());
        System.out.println("Top element: " + stack.peek());

        sc.close();
    }
}