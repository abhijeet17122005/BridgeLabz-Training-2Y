import java.util.Scanner;
public class VowelConsonantCounter {
    public static String classifyChar(char ch) {
        ch = Character.toLowerCase(ch);
        if (ch >= 'a' && ch <= 'z') {
            if ("aeiou".indexOf(ch) != -1) return "Vowel";
            else return "Consonant";
        }
        return "Not a Letter";
    }
    public static int[] countVowelsConsonants(String str) {
        int vowels = 0, consonants = 0;
        for (int i = 0;; i++) {
            try {
                String type = classifyChar(str.charAt(i));
                if (type.equals("Vowel")) vowels++;
                else if (type.equals("Consonant")) consonants++;
            } catch (Exception e) {
                break;
            }
        }
        return new int[]{vowels, consonants};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        int[] result = countVowelsConsonants(input);
        System.out.println("Vowels: " + result[0]);
        System.out.println("Consonants: " + result[1]);
    }
}