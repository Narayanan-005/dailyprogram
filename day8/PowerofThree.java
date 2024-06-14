import java.util.Map;
import java.util.Scanner;

public class PowerofThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printResult(powerofThree1(n));
        printResult(powerofThree2(n));
        printResult(powerofThree3(n));
    }

    private static void printResult(boolean status) {
        if (status) {
            System.out.println("The given Number is Power of Three");
        } else {
            System.out.println("The given Number is not a Power of Three");
        }
    }

    private static boolean powerofThree1(int n) {
        while (n >= 3) {
            if (n % 3 != 0) {
                return false;
            }
            n /= 3;
        }
        return n == 1;
    }

    private static boolean powerofThree2(int n) {
        if (n < 3) {
            return n == 1;
        } else if (n % 3 != 0) {
            return false;
        }
        return powerofThree2(n / 3);
    }

    private static boolean powerofThree3(int n) {
        if (n < 1) {
            return false;
        }
        double remaining = Math.log10(n) / Math.log10(3);
        return remaining - Math.floor(remaining) == 0;
    }
}
