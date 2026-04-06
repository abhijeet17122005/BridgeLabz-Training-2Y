/**
 * Real-World Q3. User Input Validation (Login System)
 * Scenario: When users enter their age during signup, it comes as a String.
 *           You need to verify:
 *             - The age is a valid integer.
 *             - The user is 18 or older.
 * Task: Write a method that returns true if valid and >= 18, else false.
 */

public class RW3_UserInputValidation {

    public static boolean isValidAdult(String ageInput) {
        try {
            int age = Integer.parseInt(ageInput);   // wrapper utility method
            return age >= 18;
        } catch (NumberFormatException e) {
            return false;  // not a valid integer
        }
    }

    public static void main(String[] args) {
        String[] testAges = {"25", "16", "abc", "18", "-5", "0"};

        System.out.println("Age Validation Results:");
        for (String age : testAges) {
            boolean result = isValidAdult(age);
            System.out.println("  isValidAdult(\"" + age + "\") = " + result);
        }
    }
}

/*
 Expected Output:
 Age Validation Results:
   isValidAdult("25")  = true
   isValidAdult("16")  = false
   isValidAdult("abc") = false
   isValidAdult("18")  = true
   isValidAdult("-5")  = false
   isValidAdult("0")   = false
*/
