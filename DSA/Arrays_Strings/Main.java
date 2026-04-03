import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Rearranging
        int i = 0;   // even index
        int j = 1;   // odd index

        while (i < n && j < n) {

            if (nums[i] % 2 == 0) {
                i += 2;
            }
            else if (nums[j] % 2 == 1) {
                j += 2;
            }
            else {
                // swap
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        // Output
        System.out.println("Rearranged Array:");
        for (int k = 0; k < n; k++) {
            System.out.print(nums[k] + " ");
        }

        sc.close();
    }
}

