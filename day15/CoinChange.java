import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int arr[] = {1, 2, 5};
        System.out.println(coinChange1(arr, 11));
        System.out.println(coinChange2(arr, 11));
    }

    private static int coinChange1(int[] coin, int total) {
        int count[] = new int[total + 1];
        Arrays.fill(count, total + 1);
        count[0] = 0;
        for (int i = 1; i <= total; i++) {
            for (int j = 0; j < coin.length; j++) {
                if (i - coin[j] >= 0) {
                    count[i] = Math.min(count[i], 1 + count[i - coin[j]]);
                }
            }
        }
        return count[total] != total + 1 ? count[total] : -1;
    }

    private static int coinChange2(int[] coin, int total) {
        if (total < 1) return 0;
        int[] l = new int[total];
        Arrays.fill(l, Integer.MAX_VALUE);

        return calculateMinimumCoins(coin, total, l);
    }

    public static int calculateMinimumCoins(int[] coins, int rem, int[] counter) {
        int result = 0;
        if (rem < 0) {
            return -1;
        } else if (rem == 0) {
            return 0;
        } else if (counter[rem - 1] != Integer.MAX_VALUE) {
            return counter[rem - 1];
        }
        int minimum = Integer.MAX_VALUE;
        for (int j = 0; j < coins.length; j++) {
            result = calculateMinimumCoins(coins, rem - coins[j], counter);
            if (result >= 0 && result < minimum) {
                minimum = 1 + result;
            }
        }
        if (minimum != Integer.MAX_VALUE) {
            counter[rem - 1] = minimum;
        } else {
            counter[rem - 1] = -1;
        }
        return counter[rem - 1];
    }

}
