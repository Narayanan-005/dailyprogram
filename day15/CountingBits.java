import java.util.Arrays;
import java.util.Scanner;

public class CountingBits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(Arrays.toString(countingBits1(n)));
        System.out.println(Arrays.toString(countingBits2(n)));
        int ans[] = new int[n + 1];
        System.out.println(Arrays.toString(countingBits3(ans, 1, 1)));
    }

    private static int[] countingBits1(int n) {
        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int count = 0;
            int temp = i;
            while (temp != 0) {
                if (temp % 2 == 1) {
                    count++;
                }
                temp /= 2;
            }
            arr[i] = count;
        }
        return arr;
    }

    private static int[] countingBits2(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i / 2] + (i & 1);
        }
        return ans;
    }

    private static int[] countingBits3(int arr[], int index, int k) {
        if (index == arr.length) {
            return arr;
        }
        if (k * 2 == index) {
            k *= 2;
        }
        arr[index] = arr[index - k] + 1;
        return countingBits3(arr, index + 1, k);
    }
}
