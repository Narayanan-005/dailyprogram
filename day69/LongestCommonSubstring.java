public class LongestCommonSubstring {
    public static void main(String[] args) {

    }

    private static int longestCommonSubstring1(String str1, String str2) {
        int max = 0;
        for (int i = 0; i < str1.length(); i++) {
            for (int j = i; j < str1.length(); j++) {
                if (str2.contains(str1.substring(i, j + 1))) {
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                    }
                }
            }
        }
        return max;
    }

    private static int longestCommonSubstring2(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int dp[][] = new int[1001][1001];
        for (int i = 0; i < n; ++i) dp[i][0] = 0;
        for (int i = 0; i < m; ++i) dp[0][i] = 0;
        int res = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = 0;
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
