import java.util.Arrays;

public class MIssingNumber1 {
    public static void main(String[] args) {
        int arr[] = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(missingNumber(arr));
    }

    public static int missingNumber(int arr[]) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (i != arr[i]) {
                return i;
            }
        }
        return arr.length;
    }
}
