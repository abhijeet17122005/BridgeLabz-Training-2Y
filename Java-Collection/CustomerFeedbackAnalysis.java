import java.util.*;

public class CustomerFeedbackAnalysis {
    public static void main(String[] args) {
        List<String> allFeedback = new ArrayList<>();
        allFeedback.add("Great product");
        allFeedback.add("Late delivery");
        allFeedback.add("Great product"); // duplicate
        allFeedback.add("Poor packaging");

        // remove duplicates with Set
        Set<String> unique = new LinkedHashSet<>(allFeedback);
        System.out.println("Unique feedbacks: " + unique);

        // process in order using queue
        Queue<String> processQueue = new LinkedList<>(unique);
        Stack<String> recentStack = new Stack<>();

        while (!processQueue.isEmpty()) {
            String f = processQueue.poll();
            System.out.println("Processing feedback: " + f);
            recentStack.push(f);
        }

        // show last few
        System.out.println("Last few feedbacks (most recent first):");
        int count = 0;
        while (!recentStack.isEmpty() && count++ < 3) {
            System.out.println(" - " + recentStack.pop());
        }
    }
}
