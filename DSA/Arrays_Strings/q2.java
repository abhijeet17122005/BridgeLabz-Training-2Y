import java.util.*;

public class q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] arr = {
            {1, 2, 3},    
            {2, 4, 5}
        };

        int[][] arr2 = new int[3][2];
        int[][] mul = new int[2][2];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                arr2[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    mul[i][j] += arr[i][k] * arr2[k][j];
                }
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(mul[i][j] + " ");
            }
            System.out.println();
        }
    }
}
