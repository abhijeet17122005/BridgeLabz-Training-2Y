import java.util.*;

class DeleteConsecutiveWordsInString {
    public static String removeDuplicates(String sentence) {
        String[] words = sentence.split(" ");
        Stack<String> stack = new Stack<>();

        for (String word : words) {
            if (stack.isEmpty() || !stack.peek().equals(word)) {
                stack.push(word);
            }
        }

        // Build result
        StringBuilder result = new StringBuilder();
        for (String word : stack) {
            result.append(word).append(" ");
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        String input = "hello hello world world world java";
        System.out.println(removeDuplicates(input));
    }
}