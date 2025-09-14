package OOPS.Class_Objects;

class PalindromeChecker {
    private String text;

    public PalindromeChecker(String text) {
        this.text = text;
    }

    public boolean isPalindrome() {
        String reversed = new StringBuilder(text).reverse().toString();
        return text.equalsIgnoreCase(reversed);
    }

    public void displayResult() {
        System.out.println(text + " is palindrome? " + isPalindrome());
    }

    public static void main(String[] args) {
        PalindromeChecker p = new PalindromeChecker("Level");
        p.displayResult();
    }
}
