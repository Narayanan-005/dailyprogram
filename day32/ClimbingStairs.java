import java.util.Scanner;

public class ClimbingStairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(climbingStairs1(n));
        System.out.println(climbingStairs2(n));
        System.out.println(climbingStairs3(n));
    }

    private static int climbingStairs1(int n) {
        int n1 = 1;
        int n2 = 1;
        int n3 = 1;
        for (int i = 0; i < n - 1; i++) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
        return n3;
    }

    private static int climbingStairs2(int n) {
        int dp[] = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    private static int climbingStairs3(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return climbingStairs3(n - 1) + climbingStairs3(n - 2);
    }
}
