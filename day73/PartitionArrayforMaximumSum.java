import java.util.Arrays;

public class PartitionArrayforMaximumSum {
    public static void main(String[] args) {
        System.out.println(partitionArrayforMaximumSum1(new int[]{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4));
        System.out.println(partitionArrayforMaximumSum2(new int[]{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4));
    }

    private static int partitionArrayforMaximumSum1(int[] arr, int k) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) dp[i] = -1;
        return find(0, arr, k, dp);
    }

    public static int find(int ind, int[] arr, int k, int[] dp) {
        int n = arr.length;
        if (ind == n) return 0;
        if (dp[ind] != -1) return dp[ind];
        int len = 0, maxi = Integer.MIN_VALUE, maxAns = Integer.MIN_VALUE;
        for (int j = ind; j < Math.min(ind + k, n); j++) {
            len++;
            maxi = Math.max(maxi, arr[j]);
            int sum = len * maxi + find(j + 1, arr, k, dp);
            maxAns = Math.max(maxAns, sum);
        }
        return dp[ind] = maxAns;
    }

    private static int partitionArrayforMaximumSum2(int[] arr, int k) {
        int N = arr.length;
        int K = k + 1;
        int[] dp = new int[k + 1];
        for (int start = N - 1; start >= 0; start--) {
            int currMax = 0;
            int end = Math.min(N, start + k);
            for (int i = start; i < end; i++) {
                currMax = Math.max(currMax, arr[i]);
                dp[start % K] = Math.max(dp[start % K], dp[(i + 1) % K] + currMax * (i - start + 1));
            }
        }
        return dp[0];
    }
}
