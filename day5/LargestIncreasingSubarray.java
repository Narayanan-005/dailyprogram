import java.util.Arrays;
import java.util.Scanner;

public class LargestIncreasingSubarray {
    public static void main(String[] args) {
        int arr[] = {4, 1, 4, 1, 3, 6, 8, 6, 5, 7, 12, 23, 45, 100};
        System.out.println(largestIncreasingSubarray1(arr));
        System.out.println(largestIncreasingSubarray2(arr));
        System.out.println(largestIncreasingSubarray3(arr));
    }

    public static int largestIncreasingSubarray1(int arr[]) {
        int maxLen = 0;
        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] <= arr[i]) {
                count++;
            } else {
                maxLen = Math.max(count, maxLen);
                count = 1;
            }
        }
        maxLen = Math.max(count, maxLen);

        return maxLen;
    }

    public static int largestIncreasingSubarray2(int arr[]) {
        int temp[] = new int[arr.length];
        Arrays.fill(temp, 1);
        int maxLen = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] <= arr[i]) {
                temp[i] += temp[i - 1];
            }
            if (maxLen < temp[i]) {
                maxLen = temp[i];
            }
        }

        return maxLen;
    }

    public static int largestIncreasingSubarray3(int arr[]) {
        int maxLen = 0;
        int i = 1, j = 0;

        for (; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                maxLen = Math.max(maxLen, i - j);
                j = i;
            }
        }

        maxLen = Math.max(maxLen, i - j);
        return maxLen;
    }
}
