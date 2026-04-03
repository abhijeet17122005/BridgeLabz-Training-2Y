import java.util.Scanner;

public class PangramCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String s = sc.nextLine();
        System.out.println(isPangram(s) ? "Pangram" : "Not a Pangram");
        sc.close();
    }

    public static boolean isPangram(String s) {
        boolean[] seen = new boolean[26];
        s = s.toLowerCase();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                seen[c - 'a'] = true;
            }
        }

        for (boolean b : seen) {
            if (!b) return false;
        }
        return true;
    }
}
