/**
 * Q6. Input Conversion Utility
 * Write a method:
 *   public static int safeParseInt(String input)
 * that tries to convert a String to an integer using Integer.parseInt().
 * If it fails (throws NumberFormatException), return -1.
 * Test it with inputs: "123", "abc", "45.6", "0".
 */

public class Q6_InputConversionUtility {

    public static int safeParseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static void main(String[] args) {
        String[] testInputs = {"123", "abc", "45.6", "0"};

        for (String input : testInputs) {
            int result = safeParseInt(input);
            System.out.println("safeParseInt(\"" + input + "\") = " + result);
        }
    }
}

/*
 Expected Output:
 safeParseInt("123")  = 123
 safeParseInt("abc")  = -1
 safeParseInt("45.6") = -1
 safeParseInt("0")    = 0
*/
