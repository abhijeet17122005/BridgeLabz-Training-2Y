import java.util.*;

public class LibraryManagementSystem {
    static class Book {
        final String isbn;
        final String title;
        Book(String isbn, String title){ this.isbn=isbn; this.title=title; }
        public String toString(){ return title + "(" + isbn + ")"; }
    }

    public static void main(String[] args) {
        List<Book> allBooks = new ArrayList<>();
        Set<String> memberIds = new HashSet<>();
        Queue<Book> issueQueue = new LinkedList<>();
        Stack<Book> returnedStack = new Stack<>();

        // add books
        allBooks.add(new Book("ISBN1","Java 101"));
        allBooks.add(new Book("ISBN2","DSA Basics"));

        // register members
        registerMember("M1", memberIds);
        registerMember("M1", memberIds); // duplicate

        // issue flow
        issueQueue.add(allBooks.get(0));
        if (!issueQueue.isEmpty()) {
            Book toIssue = issueQueue.poll();
            System.out.println("Issuing " + toIssue);
            // after return
            returnedStack.push(toIssue);
        }

        // re-issue most recently returned
        if (!returnedStack.isEmpty()) {
            Book recent = returnedStack.pop();
            System.out.println("Re-issuing recent returned book: " + recent);
        }
    }

    static void registerMember(String id, Set<String> members) {
        if (members.add(id)) System.out.println("Member registered: " + id);
        else System.out.println("Member " + id + " already exists");
    }
}
