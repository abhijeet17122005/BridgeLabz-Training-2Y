import java.util.Scanner;

public class StoreValuesSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] values = new double[10];
        double total = 0.0;
        int index = 0;

        // Infinite loop until user enters 0 or negative
        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            double num = sc.nextDouble();

            if (num <= 0 || index == 10) {
                break;
            }

            values[index] = num;
            index++;
        }

        // Calculate total
        for (int i = 0; i < index; i++) {
            total += values[i];
        }

        // Display stored values
        System.out.println("Stored numbers:");
        for (int i = 0; i < index; i++) {
            System.out.print(values[i] + " ");
        }
        System.out.println("\nTotal = " + total);

        sc.close();
    }
}
