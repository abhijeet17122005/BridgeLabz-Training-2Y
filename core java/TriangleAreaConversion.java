import java.util.Scanner;

public class TriangleAreaConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter base in cm: ");
        double base = sc.nextDouble();

        System.out.print("Enter height in cm: ");
        double height = sc.nextDouble();

        double areaCm2 = 0.5 * base * height;
        double areaInches2 = areaCm2 / (2.54 * 2.54); // 1 in = 2.54 cm

        System.out.println("The Area of the triangle in sq in is " + areaInches2 +
                           " and sq cm is " + areaCm2);
    }
}
