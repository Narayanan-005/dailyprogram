import java.util.Scanner;

public class NimGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printResult(nimGame1(n));
        printResult(nimGame2(n));
    }

    private static void printResult(boolean b) {
        if (b) {
            System.out.println("You wins");
        } else {
            System.out.println("another player wins");
        }
    }

    private static boolean nimGame1(int n) {
        return n % 4 != 0;
    }

    private static boolean nimGame2(int n) {
        if (n <= 3)
            return true;
        boolean arr[] = new boolean[n + 1];
        arr[1] = arr[2] = arr[3] = true;
        for (int i = 4; i <= n; i++) {
            arr[i] = !arr[i - 2] || !arr[i - 1] || !arr[i - 3];
        }
        return arr[n];
    }
}
