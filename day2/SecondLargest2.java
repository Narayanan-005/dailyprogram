import java.util.Arrays;

public class SecondLargest2 {
    public static void main(String[] args) {
        int arr[] = {3, 4, 8, 12, 34, 0, 4, 56};
        System.out.println("Second Largest Number is : " + secondLargest(arr, 2));
    }

    public static int secondLargest(int[] arr, int n) {
        Arrays.sort(arr);
        return arr[arr.length - n];
    }
}
