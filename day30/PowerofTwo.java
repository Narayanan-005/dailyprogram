import java.util.Scanner;

public class PowerofTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printResult(powerofTwo1(n));
        printResult(powerofTwo2(n));
        printResult(powerofTwo3(n));
    }

    private static void printResult(boolean b) {
        if (b) {
            System.out.println("The given number is power of 2");
        } else {
            System.out.println("The given number is not a power of 2");
        }
    }

    private static boolean powerofTwo1(int n) {
        if (n < 1) {
            return false;
        }
        while (n != 1) {
            if (n % 2 != 0) {
                return false;
            }
            n /= 2;
        }
        return true;
    }

    private static boolean powerofTwo2(int n) {
        if (n < 1 || n % 2 != 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    private static boolean powerofTwo3(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n >> i & 1) == 1) {
                count++;
            }
        }
        return count == 1;
    }
}
