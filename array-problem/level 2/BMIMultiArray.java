import java.util.Scanner;

public class BMIMultiArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();

        double[][] personData = new double[number][3]; // height, weight, BMI
        String[] weightStatus = new String[number];

        for (int i = 0; i < number; i++) {
            System.out.println("\nEnter details for person " + (i + 1));

            System.out.print("Enter height (in meters): ");
            double height = sc.nextDouble();
            while (height <= 0) {
                System.out.print("Enter a positive value for height: ");
                height = sc.nextDouble();
            }

            System.out.print("Enter weight (in kg): ");
            double weight = sc.nextDouble();
            while (weight <= 0) {
                System.out.print("Enter a positive value for weight: ");
                weight = sc.nextDouble();
            }

            double bmi = weight / (height * height);

            personData[i][0] = height;
            personData[i][1] = weight;
            personData[i][2] = bmi;

            if (bmi <= 18.4) weightStatus[i] = "Underweight";
            else if (bmi <= 24.9) weightStatus[i] = "Normal";
            else if (bmi <= 39.9) weightStatus[i] = "Overweight";
            else weightStatus[i] = "Obese";
        }

        System.out.println("\nBMI Report:");
        for (int i = 0; i < number; i++) {
            System.out.printf("Person %d: Height=%.2fm, Weight=%.2fkg, BMI=%.2f, Status=%s\n",
                    (i + 1), personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }
        sc.close();
    }
}
