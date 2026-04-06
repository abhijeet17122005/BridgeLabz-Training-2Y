/**
 * Q8. Character Wrapper Use Case
 * Write a program that counts:
 *  - Total letters
 *  - Total digits
 *  - Total special characters
 * in a string entered by the user.
 * Use Character.isLetter(), Character.isDigit(), Character.isWhitespace().
 */

import java.util.Scanner;

public class Q8_CharacterWrapperUseCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        int letters = 0, digits = 0, special = 0;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (Character.isLetter(ch)) {
                letters++;
            } else if (Character.isDigit(ch)) {
                digits++;
            } else if (!Character.isWhitespace(ch)) {
                // Not a letter, not a digit, not whitespace → special character
                special++;
            }
        }

        System.out.println("\nInput String       : " + input);
        System.out.println("Total Letters      : " + letters);
        System.out.println("Total Digits       : " + digits);
        System.out.println("Total Special Chars: " + special);

        sc.close();
    }
}

/*
 Sample Run:
 Enter a string: Hello@123!
 Total Letters      : 5
 Total Digits       : 3
 Total Special Chars: 2
*/
