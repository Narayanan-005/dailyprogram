import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int arr[] = {-1, 2, 1, -4};
        System.out.println(threeSumClosest1(arr, 1));
        System.out.println(threeSumClosest2(arr, 1));
    }

    private static int threeSumClosest1(int[] arr, int target) {
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    int temp = arr[i] + arr[j] + arr[k];
                    if (Math.abs(target - temp) < Math.abs(target - sum)) {
                        sum = temp;
                    }
                }
            }
        }
        return sum;
    }

    private static int threeSumClosest2(int[] arr, int target) {
        Arrays.sort(arr);
        int l = arr.length;
        int preDiff = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < l - 2; i++) {
            int j = i + 1;
            int k = l - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
                int currDiff = Math.abs(sum - target);
                if (currDiff < preDiff) {
                    res = sum;
                    preDiff = currDiff;
                }
            }
        }
        return res;
    }
}
