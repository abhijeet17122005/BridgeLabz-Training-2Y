/**
 * Q5. Wrapper Class Utility Methods
 * Write a program that demonstrates the use of the following methods:
 *  - Integer.parseInt("123")
 *  - Double.parseDouble("3.14")
 *  - Boolean.parseBoolean("true")
 *  - Integer.toBinaryString(10)
 *  - Character.isDigit('5')
 *  - Character.toUpperCase('a')
 *  Print the result of each method.
 */

public class Q5_WrapperUtilityMethods {
    public static void main(String[] args) {
        // Parse String to int
        int parsedInt = Integer.parseInt("123");
        System.out.println("Integer.parseInt(\"123\")          = " + parsedInt);

        // Parse String to double
        double parsedDouble = Double.parseDouble("3.14");
        System.out.println("Double.parseDouble(\"3.14\")       = " + parsedDouble);

        // Parse String to boolean
        boolean parsedBool = Boolean.parseBoolean("true");
        System.out.println("Boolean.parseBoolean(\"true\")     = " + parsedBool);

        // Convert int to binary string
        String binary = Integer.toBinaryString(10);
        System.out.println("Integer.toBinaryString(10)       = " + binary);

        // Check if character is a digit
        boolean isDigit = Character.isDigit('5');
        System.out.println("Character.isDigit('5')           = " + isDigit);

        // Convert character to uppercase
        char upper = Character.toUpperCase('a');
        System.out.println("Character.toUpperCase('a')       = " + upper);
    }
}
