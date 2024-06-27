public class BestTimetoBuyandSellStock {
    public static void main(String[] args) {
        int input[] = {7, 1, 5, 3, 6, 4};
        System.out.println(bestTimetoBuyandSellStock1(input));
        System.out.println(bestTimetoBuyandSellStock2(input));
        System.out.println(bestTimetoBuyandSellStock3(input));
    }

    private static int bestTimetoBuyandSellStock1(int arr[]) {
        int buy = arr[0];
        int res;
        int profit = 0;
        for (int i = 1; i < arr.length; i++) {
            if (buy > arr[i]) {
                buy = arr[i];
            }
            res = arr[i] - buy;
            if (res > profit) {
                profit = res;
            }
        }
        return profit;
    }

    private static int bestTimetoBuyandSellStock2(int arr[]) {
        int buy = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < buy) {
                buy = arr[i];
            } else if (arr[i] - buy > profit) {
                profit = arr[i] - buy;
            }
        }
        return profit;
    }

    private static int bestTimetoBuyandSellStock3(int arr[]) {
        int n = arr.length;
        int[] dp = new int[n];
        int buy = arr[0];
        for (int i = 1; i < n; i++) {
            if (buy > arr[i]) {
                buy = arr[i];
            }
            dp[i] = Math.max(dp[i - 1], arr[i] - buy);
        }
        return dp[n - 1];
    }
}
