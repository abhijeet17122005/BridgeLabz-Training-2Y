import java.util.*;

class PostfixEval {
    public static int evaluatePostfix(String s) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            } else {
                int b = stack.pop();
                int a = stack.pop();

                if (ch == '+') stack.push(a + b);
                else if (ch == '-') stack.push(a - b);
                else if (ch == '*') stack.push(a * b);
                else if (ch == '/') stack.push(a / b);
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String exp = "231*+9-";
        System.out.println(evaluatePostfix(exp));
    }
} 
