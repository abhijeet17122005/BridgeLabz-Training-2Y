// create two arrays one from your size and one take form the user and then find the addition of the both 2d arrays:-
import java.util.*;
public class q1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = {{1,2,3}
                        ,{2,4,5}};
        int[][] arr2 = new int[2][3];
        int[][] sum = new int[2][3];
        for(int i = 0; i <2 ; i++){
            for(int j = 0; j<3 ; j++){
                arr2[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i <2 ; i++){
            for(int j = 0; j<3 ; j++){
                sum[i][j] = arr[i][j] + arr2[i][j];
            }
        }
        for(int i = 0; i <2 ; i++){
            for(int j = 0; j<3 ; j++){
                System.out.print(sum[i][j]+" ");
            }
            System.out.println();
        }
    }
}