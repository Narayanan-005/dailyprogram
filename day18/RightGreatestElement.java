import java.util.Arrays;

public class RightGreatestElement {
    public static void main(String[] args) {
        int arr[] = {16, 17, 4, 3, 5, 2};
        System.out.println(Arrays.toString(rightGreatestElement1(arr.clone())));
        System.out.println(Arrays.toString(rightGreatestElement2(arr.clone())));
        System.out.println(Arrays.toString(rightGreatestElement3(arr.clone())));
    }

    private static int[] rightGreatestElement1(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int max = -1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                }
            }
            arr[i] = max;
        }
        return arr;
    }

    private static int[] rightGreatestElement2(int arr[]) {
        int max = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = max;
            if (arr[i] > max) {
                max = arr[i];
            }
            arr[i] = temp;
        }
        return arr;
    }

    private static int[] rightGreatestElement3(int arr[]) {
        int n = arr.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        for (int i = n - 2; i >= 0; i--) {
            res[i] = Math.max(arr[i + 1], res[i + 1]);
        }
        return res;
    }
}
