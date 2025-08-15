import java.util.Scanner;

public class CourseFeeDiscountUser {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Student Fee: ");
        double fee = input.nextDouble();
        System.out.print("Enter Discount Percent: ");
        double discountPercent = input.nextDouble();

        double discountAmount = (discountPercent / 100) * fee;
        double finalFee = fee - discountAmount;

        System.out.println("The discount amount is INR " + discountAmount +
                           " and final discounted fee is INR " + finalFee);
    }
}
