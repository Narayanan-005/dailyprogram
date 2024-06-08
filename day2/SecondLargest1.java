import java.util.Arrays;

public class SecondLargest1 {
    public static void main(String[] args) {
        int arr[] = {3, 4, 8, 12, 34, 0, 4, 56};
        System.out.println("Second Largest Number is : " + secondLargest(arr, 2));
    }

    public static int secondLargest(int arr[], int n) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = 0;
            for (int j = 1; j < arr.length; j++) {
                if (arr[max] < arr[j]) {
                    max = j;
                }
            }
            if (i == n - 1) {
                break;
            }
            arr[max] = Integer.MIN_VALUE;
        }
        return arr[max];
    }
}
