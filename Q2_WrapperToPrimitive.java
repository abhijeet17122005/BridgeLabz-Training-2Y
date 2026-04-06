/**
 * Q2. Wrapper to Primitive Conversion
 * Given a Double object with a value of 45.67, convert it into:
 *  - double (unboxing)
 *  - int (using casting)
 *  - Print all the values.
 */

public class Q2_WrapperToPrimitive {
    public static void main(String[] args) {
        Double wrapperDouble = 45.67;          // auto-boxing

        // Unboxing to double
        double primitiveDouble = wrapperDouble; // auto-unboxing

        // Cast to int (truncates decimal part)
        int primitiveInt = (int) (double) wrapperDouble;

        System.out.println("Double object value : " + wrapperDouble);
        System.out.println("Primitive double    : " + primitiveDouble);
        System.out.println("Primitive int (cast): " + primitiveInt);
    }
}
