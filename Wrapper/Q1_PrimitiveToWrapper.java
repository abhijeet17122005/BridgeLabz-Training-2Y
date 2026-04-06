/**
 * Q1. Primitive to Wrapper Conversion
 * Write a Java program that takes an integer input from the user and:
 *  - Converts it into an Integer object.
 *  - Displays the value using both the primitive and object forms.
 */

import java.util.Scanner;

public class Q1_PrimitiveToWrapper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int primitiveValue = sc.nextInt();

        // Boxing: primitive -> wrapper object
        Integer wrapperObject = Integer.valueOf(primitiveValue);

        System.out.println("Primitive int value : " + primitiveValue);
        System.out.println("Integer object value: " + wrapperObject);
        System.out.println("Are they equal?      " + (primitiveValue == wrapperObject)); // auto-unboxing
        sc.close();
    }
}
