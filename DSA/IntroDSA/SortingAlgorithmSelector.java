
import java.util.Arrays;

public class SortingAlgorithmSelector {

    static void bubbleSort(int[] arr){
        int n = arr.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    static void insertionSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int key = arr[i];
            int j = i-1;

            while(j>=0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    static void mergeSort(int[] arr){
        Arrays.sort(arr);
    }

    public static void main(String[] args){
        int[] arr = {5,2,9,1,5,6};

        bubbleSort(arr);
        System.out.println("Bubble Sorted: " + Arrays.toString(arr));

        int[] arr2 = {5,2,9,1,5,6};
        insertionSort(arr2);
        System.out.println("Insertion Sorted: " + Arrays.toString(arr2));

        int[] arr3 = {5,2,9,1,5,6};
        mergeSort(arr3);
        System.out.println("Merge Sorted: " + Arrays.toString(arr3));
    }
}

