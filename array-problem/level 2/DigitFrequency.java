import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step a: Take input for number
        System.out.print("Enter a number: ");
        long number = sc.nextLong();

        // Handle negative numbers by converting to positive
        number = Math.abs(number);

        // Step b: Count digits and save digits into an array
        String numStr = Long.toString(number);
        int count = numStr.length();
        int[] digits = new int[count];

        for (int i = 0; i < count; i++) {
            digits[i] = numStr.charAt(i) - '0'; // Convert char to int
        }

        // Step d: Frequency array of size 10 (digits 0-9)
        int[] frequency = new int[10];
        for (int digit : digits) {
            frequency[digit]++;
        }

        // Step e: Display frequency of each digit
        System.out.println("\nDigit Frequency:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + " occurs " + frequency[i] + " time(s)");
            }
        }
        sc.close();
    }
}
