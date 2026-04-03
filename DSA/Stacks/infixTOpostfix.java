import java.util.*;

class infixTOpostfix {
    static int precedence(char ch) {
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        if (ch == '^') return 3;
        return -1;
    }

    static String infixToPostfix(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            } 
            else if (ch == '(') {
                stack.push(ch);
            } 
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            } 
            else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(exp));
    }
}