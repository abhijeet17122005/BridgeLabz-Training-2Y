public class NullPointerDemo {
    public static void generateException() {
        String text = null;
        System.out.println("Length of text: " + text.length());
    }
    public static void handleException() {
        String text = null;
        try {
            System.out.println("Length of text: " + text.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: text is null");
        }
    }
    public static void main(String[] args) {
        System.out.println(" Generating Exception ");
        try {
            generateException();
        } catch (NullPointerException e) {
            System.out.println("Exception occurred in generateException(): " + e);
        }

        // Step 2: Call method that handles the exception
        System.out.println("\n Handling Exception ");
        handleException();
    }
}