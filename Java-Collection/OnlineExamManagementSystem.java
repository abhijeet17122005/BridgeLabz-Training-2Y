import java.util.*;

public class OnlineExamManagementSystem {
    static class Question {
        final String id, text;
        Question(String id, String t){ this.id=id; this.text=t; }
        @Override public String toString(){ return id + ": " + text; }
    }

    static class Student {
        final String id;
        Student(String id){ this.id=id; }
        @Override public String toString(){ return id; }
    }

    public static void main(String[] args) {
        // List<Question>
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Q1","What is Java?"));
        questions.add(new Question("Q2","Explain OOP."));
        questions.add(new Question("Q3","Explain List vs Set."));

        // Set<String> for unique student IDs
        Set<String> studentIds = new HashSet<>();
        studentIds.add("S1");
        studentIds.add("S2");
        studentIds.add("S1"); // duplicate ignored
        System.out.println("Student IDs: " + studentIds);

        // Queue<Student> for waiting students
        Queue<Student> waiting = new LinkedList<>();
        waiting.add(new Student("S1"));
        waiting.add(new Student("S3"));

        // Stack<Question> for back functionality
        Stack<Question> navStack = new Stack<>();

        // Randomize questions
        Collections.shuffle(questions);
        System.out.println("Shuffled questions: " + questions);

        // Serve students
        System.out.println("Serving students in order:");
        while (!waiting.isEmpty()) {
            Student s = waiting.poll();
            System.out.println("Serving " + s);
            // student navigates: push first question, then next
            for (Question q : questions) {
                navStack.push(q);
                System.out.println("  Question shown: " + q);
            }
            // simulate back: pop last question viewed
            System.out.println("  Student presses back, last question: " + navStack.pop());
            navStack.clear(); // end session
        }
    }
}
