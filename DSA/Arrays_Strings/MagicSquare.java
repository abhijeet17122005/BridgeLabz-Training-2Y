import java.util.*;

public class MagicSquare {
    public static void main(String[] args) {

        int[][] arr = {
            {2, 7, 6},
            {9, 5, 1},
            {4, 3, 8}
        };

        int n = 3;
        int ms = 0;

        for (int j = 0; j < n; j++) {
            ms += arr[0][j];
        }

        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += arr[i][j];
            }
            if (rowSum != ms) {
                System.out.println("Not a Magic Square");
                return;
            }
        }

        for (int j = 0; j < n; j++) {
            int colSum = 0;
            for (int i = 0; i < n; i++) {
                colSum += arr[i][j];
            }
            if (colSum != ms) {
                System.out.println("Not a Magic Square");
                return;
            }
        }

        int d1 = 0, d2 = 0;
        for (int i = 0; i < n; i++) {
            d1 += arr[i][i];
            d2 += arr[i][n - 1 - i];
        }

        if (d1 != ms || d2 != ms) {
            System.out.println("Not a Magic Square");
            return;
        }

        System.out.println("Magic Square");
    }
}