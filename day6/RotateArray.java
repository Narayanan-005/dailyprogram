import java.util.Arrays;
import java.util.Scanner;

public class RotateArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arr1[] = {1, 2, 3, 4, 5, 6, 7};
        int arr2[] = {1, 2, 3, 4, 5, 6, 7};
        int arr3[] = {1, 2, 3, 4, 5, 6, 7};
        int k = scanner.nextInt();
        rotateArray1(arr1, k);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(rotateArray2(arr2, k)));
        rotateArray3(arr3, k);
        System.out.println(Arrays.toString(arr3));
    }

    public static void rotateArray1(int arr[], int k) {
        for (int i = 0; i < k; i++) {
            int j = arr.length - 1;
            int temp = arr[j--];
            for (; j >= 0; j--) {
                arr[j + 1] = arr[j];
            }
            arr[0] = temp;
        }
    }

    public static int[] rotateArray2(int arr[], int k) {
        k %= arr.length;
        int res[] = new int[arr.length];
        int j = 0;
        for (int i = arr.length - k; i < arr.length; i++) {
            res[j++] = arr[i];
        }
        for (int i = 0; i < arr.length - k; i++) {
            res[j++] = arr[i];
        }
        return res;
    }

    public static void rotateArray3(int arr[], int k) {
        k %= arr.length;
        k %= arr.length;
        rotate(arr, 0, arr.length - 1);
        rotate(arr, 0, k - 1);
        rotate(arr, k, arr.length - 1);
    }

    public static void rotate(int arr[], int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
