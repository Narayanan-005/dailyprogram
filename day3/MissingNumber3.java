import java.util.Arrays;

public class MissingNumber3 {
    public static void main(String[] args) {
        int arr[] = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(missingNumber(arr));
    }

    public static int missingNumber(int arr[]) {
        int l = arr.length;
        int sum = (l * (l + 1)) / 2;
        for (int i = 0; i < l; i++) {
            sum -= arr[i];
        }
        return sum;
    }
}
