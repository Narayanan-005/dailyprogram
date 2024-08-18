public class MinCostClimbingStairs {
    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs1(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        System.out.println(minCostClimbingStairs1(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    static int min = Integer.MAX_VALUE;

    private static int minCostClimbingStairs1(int[] cost) {
        helper(cost, 0, 0);
        helper(cost, 0, 1);
        return min;
    }

    private static void helper(int[] cost, int sum, int ind) {
        if (ind >= cost.length) {
            if (sum < min) {
                min = sum;
            }
            return;
        }
        helper(cost, sum + cost[ind], ind + 1);
        helper(cost, sum + cost[ind], ind + 2);
    }

    private static int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}
